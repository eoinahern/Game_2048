package Utils;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by eoin on 01/12/2014.
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {



        public static String direction = "";

        @Override
        public boolean onDown(MotionEvent e)
        {
            direction = "";
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            float mindist = 350;


            if(e1.getX() - e2.getX() > mindist)
            {
                direction ="LEFT";
                return true;
            }
            else if( e2.getX() - e1.getX() > mindist)
            {
                direction="RIGHT";
                return true;
            }

            if(e1.getY() - e2.getY() > mindist)
            {
                direction = "UP";
                return true;
            }
            else if(e2.getY() - e1.getY() > mindist)
            {
                direction = "DOWN";
                return true;
            }
            return false;
        }
}



