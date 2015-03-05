package nyanpassu.android.toolset.layout;

import android.view.View;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public class LayoutTool {

    public static void layout(View child, int left, int top) {
        int measuredWidth = child.getMeasuredWidth();
        int measuredHeight = child.getMeasuredHeight();

        child.layout(left, top, left + measuredWidth, top + measuredHeight);
    }
}
