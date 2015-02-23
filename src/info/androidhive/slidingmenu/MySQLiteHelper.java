package info.androidhive.slidingmenu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rudiger on 2014/12/11.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_CLIENTS = "clients";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_CELL = "cell";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_VEHICLE = "vehicle";


    private static final String DATABASE_NAME = "almegaDB.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CLIENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_COMMENT + " text, "
            + COLUMN_NAME + " text, "
            + COLUMN_SURNAME + " text, "
            + COLUMN_CELL + " text, "
            + COLUMN_EMAIL + " text, "
            + COLUMN_VEHICLE + " text "
            +");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        onCreate(db);
    }

}
