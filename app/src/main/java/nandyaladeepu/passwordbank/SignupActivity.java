package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.widget.Toast;

import utils.PrefSingleton;


/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class SignupActivity extends MyBaseActivity implements View.OnClickListener{
    static Button mSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mSignup = (Button)findViewById(R.id.signup);
        mSignup.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        passApp.prefEdit.writeBooleanPreference(Constants.IS_FIRST_TIME, false);
    }

    @Override
    public void onClick(View view) {
        EditText password = (EditText)findViewById(R.id.password);
        EditText password_confirmation = (EditText)findViewById(R.id.password);
        boolean flag = false;

        if(password.getText().toString().matches(Constants.PASSWORD_PATTERN) ||
                password_confirmation.getText().toString().matches(Constants.PASSWORD_PATTERN)){
            flag = true;
        }
        if(flag && password.getText().toString().equals(password_confirmation.getText().toString())){
            PrefSingleton p = ((PasswordApp) getApplication()).prefEdit;
            p.writeBooleanPreference(Constants.IS_LOGGED_IN, true);
            p.writePreference(Constants.PASSWORD, password.getText().toString());
            finish();
            startActivity(new Intent(this, PasswordsHome.class));
        }
        else{
            Toast.makeText(this, "Password doesn't match or invalid", Toast.LENGTH_SHORT).show();
        }

    }
}
