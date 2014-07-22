package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class SignupActivity extends MyBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        passApp.prefEdit.writeBooleanPreference("isFirst_time", false);
    }
}
