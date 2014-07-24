package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class MyBaseActivity extends Activity {
    protected DataBaseService dbConn;
    protected PasswordApp passApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passApp = (PasswordApp)getApplication();
        dbConn = passApp.getDatabase();

    }

    @Override
    protected void onStop() {
        super.onStop();
        passApp.prefEdit.writeBooleanPreference(Constants.IS_LOGGED_IN, false);
    }
}
