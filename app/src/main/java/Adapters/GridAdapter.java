package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ahern.eoin.com.game_2048.R;


/**
 * Created by eoin on 20/11/2014.
 */
public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Integer> scores;


    public GridAdapter(Context contextin, ArrayList<Integer> scoresin)
    {
        context = contextin;
        scores = scoresin;
    }


    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int i) {
        return scores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder v;

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.square_view,viewGroup, false);

           v = new ViewHolder();
           v.score = (TextView) view.findViewById(R.id.single_square);

            view.setTag(v);
        }
        else
        {
            v = (ViewHolder) view.getTag();
        }

        int score = scores.get(i);
        v.score.setText(String.valueOf(score));

        return view;
    }


    class ViewHolder
    {
       TextView score;
    }
}
