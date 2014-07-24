package utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nandyaladeepu on 2014-07-22.
 */
public class PrefSingleton{
    private static PrefSingleton mInstance;
    private Context mContext;
    public static final String TAG="PrefSingleton";
    private SharedPreferences mMyPreferences;

    private PrefSingleton(){ }

    public static PrefSingleton getInstance(Context mContext){
        if (mInstance == null) mInstance = new PrefSingleton();
        mInstance.Initialize(mContext);
        return mInstance;
    }

    public void Initialize(Context mContext){
        this.mContext = mContext;
        mMyPreferences = this.mContext.getSharedPreferences(PrefSingleton.TAG, Activity.MODE_PRIVATE);
    }

    public void writePreference(String key, String value){
        SharedPreferences.Editor e = mMyPreferences.edit();
        e.putString(key, value);
        e.commit();
    }

    public void writeBooleanPreference(String key, Boolean value){
        SharedPreferences.Editor e = mMyPreferences.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public String getPreference(String key){
        return mMyPreferences.getString(key, null);
    }

    public boolean getBooleanPreference(String key){
        return mMyPreferences.getBoolean(key, false);
    }
}

