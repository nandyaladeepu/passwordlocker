package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class StartActivity extends MyBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(passApp.isFirstTime()){
            startActivity(new Intent(this, SignupActivity.class));
        }
        if(passApp.isLoggedIn()){
            // open activity logged
            startActivity(new Intent(this, PasswordsHome.class));
        }else{
            // signup activity
            startActivity(new Intent(this, login.class));
        }
    }
}
