package nandyaladeepu.passwordbank;

import android.app.Application;

import utils.PrefSingleton;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class PasswordApp extends Application{
    DataBaseService dbConn;
    PrefSingleton prefEdit;
    @Override
    public void onCreate() {
        super.onCreate();
        prefEdit = PrefSingleton.getInstance(this);
        dbConn = new DataBaseService(this);
    }

    static boolean isLoggedIn(){
        // Use Sharedpreferences
        return true;
    }

    static boolean isFirstTime(){
        // Use Sharedpreferences
        return true;
    }

    DataBaseService getDatabase(){
        if(dbConn ==null){
            dbConn= new DataBaseService(this);
        }
        return dbConn;
    }
}
