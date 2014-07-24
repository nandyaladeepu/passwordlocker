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
        finish();
        if(passApp.noMasterPasswd()){
            startActivity(new Intent(this, SignupActivity.class));
            return;
        }
        if(passApp.isLoggedIn()){
            startActivity(new Intent(this, PasswordsHome.class));
            return;
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
