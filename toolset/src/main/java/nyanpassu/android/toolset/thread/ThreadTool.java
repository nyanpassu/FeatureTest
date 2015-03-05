package nyanpassu.android.toolset.thread;

import android.os.Looper;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public class ThreadTool {

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void checkMainThread() {
        if (!isMainThread()) {
            throw new IllegalStateException("the method should be called at main thread");
        }
    }
}
