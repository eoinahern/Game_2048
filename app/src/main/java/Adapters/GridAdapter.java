package Adapters;

import android.annotation.TargetApi;
import android.content.Context;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import Utils.ConvertInf;
import ahern.eoin.com.game_2048.R;


/**
 * Created by eoin on 20/11/2014.
 */
public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Integer> scores;
    ConvertInf converter;


    public GridAdapter(Context contextin, ArrayList<Integer> scoresin)
    {
        context = contextin;
        scores = scoresin;
        //converter = new ColourConverter();
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
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

        if(score != 0)
            v.score.setText(String.valueOf(score));

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getShape(score));
        drawable.setStroke(5, Color.WHITE);

        v.score.setBackground(drawable);

        return view;
    }

    public int getShape(int score)
    {
        switch(score)
        {
            case 0:
                return context.getResources().getColor(R.color.square);

            case 2:
                return context.getResources().getColor(R.color.square1);


            case 4:
                return context.getResources().getColor(R.color.square2);


            case 8:
                return context.getResources().getColor(R.color.square3);


            case 16:
                return context.getResources().getColor(R.color.square4);


            case 32:
                return context.getResources().getColor(R.color.square5);


            case 64:
                return context.getResources().getColor(R.color.square6);


            case 128:
                return context.getResources().getColor(R.color.square7);


            case 256:
                return context.getResources().getColor(R.color.square8);


            case 512:
                return context.getResources().getColor(R.color.square9);


            case 1024:
                return context.getResources().getColor(R.color.square10);


            case 2048:
                return context.getResources().getColor(R.color.square11);


            default:
                return context.getResources().getColor(R.color.square13);

        }
    }

    class ViewHolder
    {
       TextView score;
    }
}
