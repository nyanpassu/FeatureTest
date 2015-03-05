package app.nyanpassu.featuretest.motionevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import nyanpassu.android.toolset.layout.MeasureTool;
import nyanpassu.android.toolset.log.AndroidLog;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public class MyViewGroup extends ViewGroup {

    public static final String TAG = "MyViewGroup";

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        AndroidLog.v(TAG, "dispatch touch event . masked action : " + event.getActionMasked() + " , pointer count : " + event.getPointerCount() + " , pointer id : " + event.getPointerId(0));

        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        AndroidLog.v(TAG, "on intercept touch event . masked action : " + event.getActionMasked() + " , pointer count : " + event.getPointerCount() + " , pointer id : " + event.getPointerId(0));

        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        AndroidLog.v(TAG, "on touch event . masked action : " + event.getActionMasked() + " , pointer count : " + event.getPointerCount() + " , pointer id : " + event.getPointerId(0));

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            MeasureTool.measureChild(child, measuredWidth, measuredHeight);
        }
    }
}
