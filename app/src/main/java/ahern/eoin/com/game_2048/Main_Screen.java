package ahern.eoin.com.game_2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import Adapters.GridAdapter;
import Controllers.Game;


public class Main_Screen extends Activity {

    private GridView myGrid;
    private GridAdapter adapter;
    private Game game;
    private ArrayList<Integer> scores;
    private Button dosomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);
        myGrid = (GridView) findViewById(R.id.gridView2);

        scores = new ArrayList<Integer>();  //testarraylist to check UI
        scores.add(1);
        scores.add(2);
        scores.add(3);
        scores.add(4);
        scores.add(5);
        scores.add(6);
        scores.add(7);
        scores.add(8);

        scores.add(1);
        scores.add(2);
        scores.add(3);
        scores.add(4);
        scores.add(5);
        scores.add(6);
        scores.add(7);
        scores.add(8);


      myGrid.setAdapter(new GridAdapter(this, scores));


    }

    public void doSomething(View v)
    {

        scores.set(0,20);
        myGrid.setAdapter(new GridAdapter(this,scores ));

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
