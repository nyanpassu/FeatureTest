package app.nyanpassu.toolset.log;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public class TextViewLogger extends TextView {

    Log mLogger = new Log() {
        TextViewLogger textView = TextViewLogger.this;

        @Override
        public void d(String tag, String message) {

        }

        @Override
        public void i(String tag, String message) {

        }

        @Override
        public void v(String tag, String message) {

        }

        @Override
        public void w(String tag, String message) {

        }

        @Override
        public void e(String tag, String message) {

        }
    };

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

    public Log getLogger() {
        return mLogger;
    }

    public void styledPrint() {
        
    }
}
