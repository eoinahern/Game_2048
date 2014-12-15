package ahern.eoin.com.game_2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import Adapters.GridAdapter;
import Controllers.Game;
import Utils.GestureListener;


public class Main_Screen extends Activity{

    private GridView myGrid;
    private GridAdapter adapter;
    private Game game;
    private int score;
    private TextView scoreview;
    private ArrayList<Integer> scores;
    private GestureDetector detector;
    private Button restart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main__screen);
        myGrid = (GridView) findViewById(R.id.gridView2);
        scoreview = (TextView) findViewById(R.id.textView2);
        restart = (Button) findViewById(R.id.button);

        detector = new GestureDetector(this,new GestureListener());


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

        startGame();

    }

    private void startGame()
    {
        game = new Game();
        scoreview.setText("Score : 0");
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
        scoreview.setText("Score : " +String.valueOf(game.GetScore()));
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
