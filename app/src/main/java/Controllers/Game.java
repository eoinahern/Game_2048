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
        board.setValue(0,0,2);
        board.setValue(1,0,2);
        boardsize = board.getsize();
        rand = new Random();
    }


    public void makeMove(String direction)  //move numbers in board
    {
        ArrayList<Integer>  row = new ArrayList<Integer>();

        for(int i=0 ; i < boardsize;i++)
        {
          row = createrow(i);
          if(row.isEmpty())
              continue;

          row = addEmpties(row,direction);

          for(int j =0 ; j< boardsize;j++)
              board.setValue(j,i,row.get(j));

            //createrow
            //addempties again!!
            //addrows or cols to original board

        }
    }

    private  ArrayList<Integer> createrow(int row)  //adds all non-zero entries to arraylist
    {

        //need to cater for up and down also here! extra for loop

        ArrayList<Integer> myrow = new ArrayList<Integer>();

        for(int i =0; i < boardsize;i++)
        {
           if(board.getValue(i,row) !=0)
           {
              myrow.add( board.getValue(i,row));
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
         if(direction == LEFT && i > row.size() -1)
         {
            row.add(0);
         }
         else if(direction == RIGHT  && i <= numzeros -1)
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
        if(direction == LEFT )
        {

        }
        else if(direction == RIGHT )
        {

        }

        return row;

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
