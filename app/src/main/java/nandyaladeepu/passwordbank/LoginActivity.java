package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import utils.PrefSingleton;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class LoginActivity extends MyBaseActivity implements View.OnClickListener {
    Button mSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSignin = (Button)findViewById(R.id.login);
        mSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText tv = (EditText)findViewById(R.id.password);
        String tvText = tv.getText().toString();
        if(tvText.matches(Constants.PASSWORD_PATTERN)){
            PrefSingleton p = ((PasswordApp)getApplication()).prefEdit;
            if(p.getPreference(Constants.PASSWORD) != null &&
                    p.getPreference(Constants.PASSWORD).equals(tvText)){
                ((PasswordApp)getApplication()).prefEdit.
                        writeBooleanPreference(Constants.IS_LOGGED_IN, true);
                finish();
                startActivity(new Intent(this, PasswordsHome.class));
            }
            else{
                Toast.makeText(this, "Password is invalid", Toast.LENGTH_SHORT).
                        show();
            }
        }
        else{
            Toast.makeText(this, "Password is invalid, has atleast with 6 characters",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
