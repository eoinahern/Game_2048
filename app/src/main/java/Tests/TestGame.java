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

        public void test_getrow() //initialization test. wont work when game is complete. added dummy values to first 2 squares initially
        {
            game.makeMove("RIGHT");
            Board board = game.getboard();
            board.showBoardLog();

            int [][] testboard = board.getSquares();

            assertEquals(testboard[0][0] , 0);
            assertEquals(testboard[0][1], 0);
            assertEquals(testboard[0][2] ,2);
            assertEquals(testboard[0][3], 2);

        }

    public void test_addempties()
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
        /*on board creation count number of instances of 2 on the initialised board. should be 2 :)*/

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
    }


}
