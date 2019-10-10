package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "users.db";

    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    SQLiteDatabase database;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_USER = " CREATE TABLE "+ UsersMaster.User.TABLE_NAME +
                " ( " + UsersMaster.User._ID + " INTEGER PRIMARY KEY, " +
                UsersMaster.User.NAME + " TEXT, "+
                UsersMaster.User.PASSWORD+ " TEXT, "+
                UsersMaster.User.TYPE+ " TEXT) ";

        sqLiteDatabase.execSQL(SQL_CREATE_USER);

        String SQL_CREATE_MESSAGE = " CREATE TABLE " + UsersMaster.Message.TABLE_NAME +
                " ( " + UsersMaster.Message._ID +" INTEGER PRIMARY KEY, "+
                UsersMaster.Message.USER + " TEXT, "+
                UsersMaster.Message.SUBJECT + " TEXT, "+
                UsersMaster.Message.MESSAGE + " TEXT) ";

        sqLiteDatabase.execSQL(SQL_CREATE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addUser(String username, String password, String type){
        database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.User.NAME, username);
        values.put(UsersMaster.User.PASSWORD, password);
        values.put(UsersMaster.User.TYPE, type);

        return database.insert(UsersMaster.User.TABLE_NAME, null,values);
    }

    public String getUser(String userName, String password){
        database = getWritableDatabase();

        String projection[] = {
                UsersMaster.User._ID,
                UsersMaster.User.NAME,
                UsersMaster.User.PASSWORD,
                UsersMaster.User.TYPE
        };

        String selection = UsersMaster.User.NAME +" = ? AND "+ UsersMaster.User.PASSWORD +" = ? ";
        String selectionArgs[] = {userName, password};

        Cursor cursor = database.query(
                UsersMaster.User.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.User.TYPE));
        }
        else {
            return null;
        }
    }
}
