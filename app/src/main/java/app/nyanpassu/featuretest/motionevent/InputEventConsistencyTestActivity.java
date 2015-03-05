package app.nyanpassu.featuretest.motionevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import app.nyanpassu.featuretest.R;
import nyanpassu.android.toolset.log.TextViewLogger;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class InputEventConsistencyTestActivity extends Activity {

    @InjectView(R.id.logger)
    TextViewLogger mTextViewLogger;

    @InjectView(R.id.my_view)
    MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_event_consistency_test);
        ButterKnife.inject(this);

        mMyView.setLog(mTextViewLogger.getLog());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input_event_consistency_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
