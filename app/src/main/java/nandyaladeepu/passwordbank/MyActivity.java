package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void createPassword(View v){
        Button createPassword = (Button)findViewById(R.id.createPassword);
        EditText password = (EditText)findViewById(R.id.editText);
        if(password.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"please enter a valid password",
                    Toast.LENGTH_LONG).show();
        }
        else{
            if(password.getText().toString().length()< 6 ){
                Toast.makeText(getApplicationContext(),"your password should be a minimum of 6 charecters",
                        Toast.LENGTH_LONG).show();
            }
            Toast.makeText(getApplicationContext(),"your password is"+password.getText().toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
