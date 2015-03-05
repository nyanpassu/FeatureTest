package nyanpassu.android.toolset.log;

/**
 * Created by 丢猫 on 2015/3/4.
 */
public class Log {

    public interface LogImpl {

        public void v(String tag, String message);
        public void d(String tag, String message);
        public void i(String tag, String message);
        public void w(String tag, String message);
        public void e(String tag, String message);
    }

    public interface Logger {
        public Log getLog();
    }

    int mLevel;
    LogImpl mLogImpl;

    void setLogImpl(LogImpl logImpl) {
        mLogImpl = logImpl;
    }

    public void enable() {
        enable(android.util.Log.ASSERT);
    }

    public void enable(int level) {
        mLevel = level;
    }

    public void v(String tag, String message) {
        if (mLevel >= android.util.Log.VERBOSE) {
            mLogImpl.v(tag, message);
        }
    }

    public void d(String tag, String message){
        if (mLevel >= android.util.Log.DEBUG) {
            mLogImpl.d(tag, message);
        }
    }

    public void i(String tag, String message){
        if (mLevel >= android.util.Log.INFO) {
            mLogImpl.i(tag, message);
        }
    }

    public void w(String tag, String message){
        if (mLevel >= android.util.Log.WARN) {
            mLogImpl.w(tag, message);
        }
    }

    public void e(String tag, String message){
        if (mLevel >= android.util.Log.ERROR) {
            mLogImpl.e(tag, message);
        }
    }
}
