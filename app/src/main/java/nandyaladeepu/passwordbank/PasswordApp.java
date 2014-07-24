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

    public boolean isLoggedIn(){
        return prefEdit.getBooleanPreference(Constants.IS_LOGGED_IN);
    }

    DataBaseService getDatabase(){
        if(dbConn ==null){
            dbConn= new DataBaseService(this);
        }
        return dbConn;
    }
    public boolean noMasterPasswd(){
        return (prefEdit.getPreference(Constants.PASSWORD) == null);
    }
}
