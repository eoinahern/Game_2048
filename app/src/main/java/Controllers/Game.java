package Controllers;

import android.util.Log;
import java.util.ArrayList;
import Models.Board;
import java.util.Random;

/**
 * Created by eoin on 23/10/2014.
 */
public class Game {

    //no matter what way i look at the board there doesnt seem to be a clean solution
    //for each directional move. which may lead to this class being relatively verbose

    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";

    private Board board;
    private int boardsize;
    private Random rand;

    public Game()
    {
        board = new Board();
        boardsize = board.getsize();
        rand = new Random();

        addrandom();
        addrandom();
    }


    public void makeMove(String direction)  //move numbers in board
    {
        ArrayList<Integer>  row = new ArrayList<Integer>();

        for(int i=0 ; i < boardsize;i++)
        {
          row = createrow(i,direction);
          if(row.isEmpty())
              continue;

          row = addEmpties(row,direction);
          row = mergeLine(row, direction);



             //add row back into original board. need method for this
            // as could be added horizontally or vertically

           addToBoard(i,direction,row);

           row = createrow(i,direction);
           row = addEmpties(row,direction);

           addToBoard(i,direction,row);


        }
    }

    private  ArrayList<Integer> createrow(int row,String direction)  //adds all non-zero entries to arraylist
    {

        //need to cater for up and down also here! extra for loop
        ArrayList<Integer> myrow = new ArrayList<Integer>();

        if(direction == UP || direction == DOWN)
        {
            for(int i = 0; i < boardsize; i++)
            {

                if (board.getValue(row, i) != 0) {
                    myrow.add(board.getValue(row, i));
                }
            }

         }
        else
        {
            for (int i = 0; i < boardsize; i++)
            {
                if (board.getValue(i, row) != 0) {
                    myrow.add(board.getValue(i, row));
                }
            }
        }

        return myrow;
    }

    public  ArrayList<Integer> addEmpties(ArrayList<Integer> row,String direction) //adds trailing/leading empty board entries
    {
        int numzeros =  boardsize - row.size();

        if(numzeros ==0)
            return row;

       for(int i =0; i < boardsize; i++)
       {
         if((direction == LEFT || direction == UP) && i > row.size() -1)
         {
            row.add(0);
         }
         else if((direction == RIGHT || direction == DOWN) && i <= numzeros -1)
         {
            row.add(i,0) ;
         }
        }

        Log.d("row :  ", row.toString());

        return row;
    }

    private ArrayList<Integer>  mergeLine(ArrayList<Integer>row, String direction)
    {

        //merge values in the line
        if(direction == LEFT  || direction == UP)
        {
            for(int i = 0; i < boardsize; i += 2)
            {
                int first = row.get(i);
                int sec = row.get(i + 1) ;

                if(first == sec && first != 0)
                {
                    row.set(i, first * 2);
                    row.set(i+ 1, 0);
                }
            }
        }
        else if(direction == RIGHT || direction == DOWN )
        {
            for(int i = boardsize - 1; i>=0; i -= 2)
            {
               int first = row.get(i);
               int sec = row.get(i-1) ;

                if(first == sec && first != 0)
                {
                    row.set(i, first * 2);
                    row.set(i - 1, 0);
                }
            }

        }

        return row;

    }

    public void addToBoard(int position, String direction,ArrayList<Integer> row)
    {

        if(direction == UP || direction == DOWN)
        {
            for(int j =0 ; j < boardsize;j++) {
                board.setValue(position, j,row.get(j));
            }

        }
        else
        {
            for(int j =0 ; j < boardsize;j++) {
                board.setValue(j, position,row.get(j));
            }


        }
    }


    public ArrayList<Integer> convertToArrLst()
    {
       //get all values from board to us to set adapter

        ArrayList<Integer> convert2d = new ArrayList<Integer>();

        for(int i =0; i < boardsize;i++)
        {
            for(int j=0; j < boardsize;j++)
            {
                convert2d.add(board.getValue(j,i));
            }
        }

        return convert2d;
    }

    public void convertToBoard(ArrayList<Integer> addarray)
    {

        //add values back to the the board

        for(int i =0; i < boardsize;i++)
        {
            for(int j=0; j < boardsize;j++)
            {
               int tempval = addarray.get((i * boardsize) + j);
               board.setValue(j, i, tempval);
            }
        }



    }


    public Board getboard()
    {
        return board;
    }

    public boolean checkWin()
    {
        for(int i =0; i < boardsize;i++)
        {
          for(int j=0; j < boardsize;j++)
          {
             if(board.getValue(j,i) == 2048)
                 return true;
          }
        }
        return false;
    }


    private void addrandom()
    {
        ArrayList<int[]> emptieslist = board.getEmptiesList();
        int size = emptieslist.size();
        int index = rand.nextInt(size);
        int [] position = emptieslist.get(index);

        int y = position[0];
        int x = position[1];

        board.setValue(x,y,2);
    }

}
