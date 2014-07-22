package nandyaladeepu.passwordbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MyActivity extends Activity {
    private List<UserBean> userContentList =  new ArrayList<UserBean>();
    private EditText password;
    private Button createPassword;
    private DataBaseService dataBaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        dataBaseService = new DataBaseService(getApplicationContext());

         createPassword = (Button)findViewById(R.id.createPassword);
         password = (EditText)findViewById(R.id.editText);
         userContentList = dataBaseService.getUsersContent();
         createPassword.setOnClickListener(button);

        if(userContentList.size()>0){
            createPassword.setText("Enter Password");
        }else{
            createPassword.setText("Create Password");
        }

    }
    private View.OnClickListener button = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            if(password.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"please enter a valid password",
                        Toast.LENGTH_LONG).show();
            }
            else{
                if(password.getText().toString().length()> 8 && Pattern.compile("[0-9]").matcher(password.getText().toString()).find() ){
                    Toast.makeText(getApplicationContext(), "your password is" + password.getText().toString(),
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"your password should be a minimum of 8 charecters and atleast one digit",
                            Toast.LENGTH_LONG).show();

                }
            }

            if(userContentList.size()>0){
                UserBean mainUser = userContentList.get(0);
                if(mainUser.getPassword().endsWith(password.getText().toString())){
                    Intent passwordsIntent = new Intent(MyActivity.this,PasswordsHome.class);
                    startActivity(passwordsIntent);
                    finish();
                }
            }else{
                UserBean mainUser = new UserBean();
                mainUser.setAccountname("mainuser");
                mainUser.setName("user");
                mainUser.setPassword(password.getText().toString());
                dataBaseService.insertAccountData(mainUser);
                userContentList.clear();
                userContentList = dataBaseService.getUsersContent();
                createPassword.setText("Enter Password");
            }
        }
    };

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
