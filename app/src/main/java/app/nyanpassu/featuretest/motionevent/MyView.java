package app.nyanpassu.featuretest.motionevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import nyanpassu.android.toolset.log.Log;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public class MyView extends View{

    public static final String TAG = "MyView";

    Log mLog;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setLog(Log log) {
        mLog = log;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mLog!=null){
            mLog.v(TAG,"masked action : "+event.getActionMasked()+" , pointer count : "+event.getPointerCount()+" , pointer id : "+event.getPointerId(0));
        }

        return super.dispatchTouchEvent(event);
    }
}