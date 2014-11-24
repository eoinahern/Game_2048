package Utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

import ahern.eoin.com.game_2048.R;

/**
 * Created by eoin on 24/11/2014.
 */
public class ColourConverter implements ConvertInf {


    public int getShape(Context context, int score)
    {
       switch(score)
        {
          case 0:
              return context.getResources().getColor(R.color.square);

          case 2:
              return context.getResources().getColor(R.color.square2);


            case 4:
                return context.getResources().getColor(R.color.square3);


            case 8:
                return context.getResources().getColor(R.color.square4);


            case 16:
                return context.getResources().getColor(R.color.square5);


            case 32:
                return context.getResources().getColor(R.color.square6);


            case 64:
                return context.getResources().getColor(R.color.square7);


            case 128:
                return context.getResources().getColor(R.color.square8);


            case 256:
                return context.getResources().getColor(R.color.square9);


            case 512:
                return context.getResources().getColor(R.color.square10);


            case 1024:
                return context.getResources().getColor(R.color.square11);


            case 2048:
                return context.getResources().getColor(R.color.square12);


            default:
                return context.getResources().getColor(R.color.square13);



        }


    }




}
