package ahern.eoin.com.game_2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.GridView;
import java.util.ArrayList;
import Adapters.GridAdapter;
import Controllers.Game;
import Utils.GestureListener;


public class Main_Screen extends Activity{

    private GridView myGrid;
    private GridAdapter adapter;
    private Game game;
    private ArrayList<Integer> scores;
    private GestureDetector detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main__screen);
        myGrid = (GridView) findViewById(R.id.gridView2);
        detector = new GestureDetector(this,new GestureListener());


        game = new Game();
        scores = game.convertToArrLst();
        myGrid.setAdapter(new GridAdapter(this, scores));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        boolean  consumed =  detector.onTouchEvent(event);
        String direction = GestureListener.direction;

        if(direction != "" && consumed == true)
        {
           handleSwipe(direction);
        }

        return super.onTouchEvent(event);
    }


    public void handleSwipe(final String direction)
    {

       ///if(game.GameOver())
          /// show game over alert

       Thread thread = new Thread(new Runnable() {


           @Override
           public void run() {
               game.makeMove(direction);
           }
       });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scores = game.convertToArrLst();
        myGrid.setAdapter(new GridAdapter(this, scores));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
