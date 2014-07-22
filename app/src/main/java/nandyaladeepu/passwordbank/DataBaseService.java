package nandyaladeepu.passwordbank;

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by nandyaladeepu on 2014-07-20.
 */
public class DataBaseService extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "USERDB";



    public DataBaseService(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE USER ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accountname TEXT NOT NULL, "+
                "username TEXT NOT NULL, "+
                "password TEXT NOT NULL )";
        // create books table
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");

        // create fresh books table
        this.onCreate(db);
    }

    public void insertAccountData(UserBean userBean){
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("accountname",userBean.getAccountname());
        values.put("username",userBean.getName());
        values.put("password",userBean.getPassword());
        // 3. insert
        db.insert("USER", // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        // 4. close
        db.close();
    }

    public List<UserBean> getUsersContent(){
        List<UserBean> users = new LinkedList<UserBean>();

        // 1. build the query
        String query = "SELECT  * FROM USER";

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        UserBean userBean = null;
        if (cursor.moveToFirst()) {
            do {
                userBean = new UserBean();
                userBean.setAccountname(cursor.getString(1));
                userBean.setName(cursor.getString(2));
                userBean.setPassword(cursor.getString(3));

                // Add book to books
                users.add(userBean);
            } while (cursor.moveToNext());
        }
        // return books
        return users;
    }
}
