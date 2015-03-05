package nyanpassu.android.toolset.log;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public class AndroidLog {

    private static Log.LogImpl sAndroidLogImpl = new Log.LogImpl() {
        @Override
        public void v(String tag, String message) {
            android.util.Log.v(tag, message);
        }

        @Override
        public void d(String tag, String message) {
            android.util.Log.d(tag, message);
        }

        @Override
        public void i(String tag, String message) {
            android.util.Log.i(tag, message);
        }

        @Override
        public void w(String tag, String message) {
            android.util.Log.w(tag, message);
        }

        @Override
        public void e(String tag, String message) {
            android.util.Log.e(tag, message);
        }
    };

    private static Log sAndroidLog = new Log();

    static {
        sAndroidLog.setLogImpl(sAndroidLogImpl);
    }

    public static void v(String tag, String message) {

    }

    public static void d(String tag, String message) {

    }

    public static void i(String tag, String message) {

    }

    public static void w(String tag, String message) {

    }

    public static void e(String tag, String message) {

    }
}
