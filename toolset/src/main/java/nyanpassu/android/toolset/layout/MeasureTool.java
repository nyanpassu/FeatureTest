package nyanpassu.android.toolset.layout;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public class MeasureTool {

    public static void measureChild(View child, int maxWidth, int maxHeight) {
        final LayoutParams lp = child.getLayoutParams();

        final int contentWidthSpec;
        if (lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
            contentWidthSpec = View.MeasureSpec.makeMeasureSpec(maxWidth, View.MeasureSpec.EXACTLY);
        } else if (lp.width == LayoutParams.WRAP_CONTENT) {
            contentWidthSpec = View.MeasureSpec.makeMeasureSpec(maxWidth, View.MeasureSpec.AT_MOST);
        } else {
            contentWidthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, View.MeasureSpec.AT_MOST);
        }

        final int contentHeightSpec;
        if (lp.height == LayoutParams.MATCH_PARENT) {
            contentHeightSpec = View.MeasureSpec.makeMeasureSpec(maxHeight, View.MeasureSpec.EXACTLY);
        } else if (lp.height == LayoutParams.WRAP_CONTENT) {
            contentHeightSpec = View.MeasureSpec.makeMeasureSpec(maxHeight, View.MeasureSpec.AT_MOST);
        } else {
            contentHeightSpec = View.MeasureSpec.makeMeasureSpec(lp.height, View.MeasureSpec.EXACTLY);
        }

        child.measure(contentWidthSpec, contentHeightSpec);
    }
}
