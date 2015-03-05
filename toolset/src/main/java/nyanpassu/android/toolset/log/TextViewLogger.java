package nyanpassu.android.toolset.log;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public class TextViewLogger extends TextView implements Log.Logger {

    Log.LogImpl mLogImpl = new Log.LogImpl() {
        TextViewLogger textView = TextViewLogger.this;

        @Override
        public void d(String tag, String message) {
            textView.styledPrint("debug", tag, message);
        }

        @Override
        public void i(String tag, String message) {
            textView.styledPrint("info", tag, message);
        }

        @Override
        public void v(String tag, String message) {
            textView.styledPrint("verbose", tag, message);
        }

        @Override
        public void w(String tag, String message) {
            textView.styledPrint("warning", tag, message);
        }

        @Override
        public void e(String tag, String message) {
            textView.styledPrint("error", tag, message);
        }
    };

    Log mLog;

    public TextViewLogger(Context context) {
        super(context);
    }

    public TextViewLogger(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewLogger(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextViewLogger(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void styledPrint(String level, String tag, String message) {
        if (isFirstLine()) {
            append(tag+"#"+message);
        } else {
            append("\n" + tag + "#" + message);
        }
        invalidate();
    }

    public boolean isFirstLine() {
        boolean noCharacter = getText().length() == 0;
        if (noCharacter) {
            return true;
        }

        final String text = getText().toString();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                return false;
            }
        }

        return true;
    }

    @Override
    public Log getLog() {
        if (mLog == null) {
            mLog = new Log();
            mLog.setLogImpl(mLogImpl);
        }

        return mLog;
    }
}
