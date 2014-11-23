package Tests;

import android.util.Log;

import junit.framework.TestCase;

import java.util.ArrayList;

import Controllers.Game;
import Models.Board;

/**
 * Created by eoin on 30/10/2014.
 */

 public class TestGame extends TestCase {

        private ArrayList<Integer> intarr;
        private Game game;

        protected  void setUp()
        {
            intarr = new  ArrayList<Integer>() ;
            game = new Game();
        }

      /*  public void test_getrow() //initialization test. wont work when game is complete. added dummy values to first 2 squares initially
        {
            game.makeMove("RIGHT");
            Board board = game.getboard();
            board.showBoardLog();

            int [][] testboard = board.getSquares();

            assertEquals(testboard[0][0] ,0);
            assertEquals(testboard[0][1], 0);
            assertEquals(testboard[0][2] ,0);
            assertEquals(testboard[0][3], 4);
            assertEquals(testboard[1][3], 16);



        }
*/
   /* public void test_addempties()
    {
        ArrayList<Integer> testlist = new ArrayList<Integer>();
        testlist.add(2);
        testlist= game.addEmpties(testlist,"RIGHT");

        assertEquals((int) testlist.get(3),2);
        assertEquals((int) testlist.get(2),0);
        assertEquals((int) testlist.get(0),0);
    }


    public void test_countrandom()
    {


       Board testboard = game.getboard();
       int [][] squares = testboard.getSquares();
       int count = 0;

        for(int i =0; i < testboard.getsize() ; i++)
        {
            for(int j=0 ; j < testboard.getsize();j++)
            {
               if(squares[i][j] == 2)
                   count++;
            }
        }

        assertEquals(2, count);
    }  */

    public void test_addempties()
    {
       Game game2 = new Game();
       int count = 0;

        game2.addrandom();
        game2.addrandom();


       int board [][]  = game2.getboard().getSquares();

        for(int i = 0; i< 4;i++)
        {
           for(int j = 0;j < 4;j++)
           {
              if(board[i][j] != 0)
              {
                  count++;
              }
           }
        }
        Log.e("count :" , String.valueOf(count));
        assertEquals(6,count);
    }

    public void test_numempties()
    {
       Game game3 = new Game();
       Board board = game.getboard();

       assertEquals(12,board.getEmptiesList().size());
    }


}
