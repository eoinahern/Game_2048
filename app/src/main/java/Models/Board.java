package Models;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by eoin on 23/10/2014.
 */
public class Board {

    private int [][] squares;
    private int numcols;
    private int numrows;
    private ArrayList<int[]> empties;

    public Board()
    {
       numcols = 4;
       numrows = 4;

       squares = new int [4][4];
       for(int i =0 ;i < numrows; i++)
       {
            for(int j =0; j < numcols;j++)
                squares[i][j] =0;
       }
    }

    public  boolean setValue(int x, int y, int val)
    {
       if ( (x < 0 || x > numcols -1) || (y <  0 ||  y > numrows -1 ))
           return false;

       squares[y][x] = val;
       return true;
    }

    public int getsize()
    {
        return numcols;
    }


    public int getValue(int x, int y)
    {
      return squares[y][x];
    }

    public boolean checkEmpty(int x, int y)
    {
       if(squares[y][x]  == 0)
           return true;

        return false;
    }

    public ArrayList<int[]> getEmptiesList()  //should this be in the controller class?? possibly
    {
       empties = new ArrayList<int[]>();

        for(int i =0 ;i < numrows; i++)
        {
            for(int j =0; j < numcols;j++)
                if(checkEmpty(j,i) == true)
                {
                    int [] coords = new int[2];
                    coords[0] = j;
                    coords[1] = i;

                    empties.add(coords);
                }
        }

        return empties;
     }

    public  int [][] getSquares()
    {
        return squares;
    }


    public void setSquares(int [][] squaresin)
    {
      squares  = squaresin;
    }

    public void showBoardLog()
    {
        for(int i = 0 ; i < numrows;i++)
        {
            Log.d("row " + String.valueOf(i),String.valueOf(squares[i][0]) + ", " +String.valueOf(squares[i][1])
            + ", " + String.valueOf(squares[i][2]) + ", " + String.valueOf(squares[i][3]));
        }
    }
}
