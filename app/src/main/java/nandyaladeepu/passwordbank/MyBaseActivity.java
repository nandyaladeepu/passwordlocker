package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.os.Bundle;

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
}
