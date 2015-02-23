package info.androidhive.slidingmenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudiger on 2014/12/11.
 */
public class LocalStorage implements PersistanceInterface {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_COMMENT,
            MySQLiteHelper.COLUMN_VEHICLE,
            MySQLiteHelper.COLUMN_EMAIL,
            MySQLiteHelper.COLUMN_CELL,
            MySQLiteHelper.COLUMN_SURNAME,
            MySQLiteHelper.COLUMN_NAME };

    public LocalStorage(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void openRO() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public void addClient(Client client) {
        System.out.println("Attempting to add client to db: "+client.toString());
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_COMMENT, client.getComment());
        values.put(MySQLiteHelper.COLUMN_VEHICLE, client.getVehicle());
        values.put(MySQLiteHelper.COLUMN_EMAIL, client.getEmail());
        values.put(MySQLiteHelper.COLUMN_CELL, client.getCell());
        values.put(MySQLiteHelper.COLUMN_SURNAME, client.getSurname());
        values.put(MySQLiteHelper.COLUMN_NAME, client.getName());

        long insertId = database.insert(MySQLiteHelper.TABLE_CLIENTS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CLIENTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();

        Client newClient = new Client();
        newClient = newClient.cursorToClient(cursor);
        cursor.close();
        //we can log cursor if we want to
        System.out.println("Added client to db: "+newClient.toString());
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<Client>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_CLIENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        Client helper = new Client();
        while (!cursor.isAfterLast()) {
            Client comment = helper.cursorToClient(cursor);
            clients.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        helper = null;
        return clients;
    }

    @Override
    public Client getClient(String cell, String name, String surname) {
        if(cell == null) cell = "";
        if(name == null) name = "";
        if(surname == null) surname = "";
        Client helper = new Client();

        String sql = "SELECT * FROM "+dbHelper.TABLE_CLIENTS+" where "
                +dbHelper.COLUMN_CELL+" like '%"+cell+"%' and where "
                +dbHelper.COLUMN_NAME+" like '%"+name+"%' ";
        Cursor result = database.rawQuery(sql, null);

        if(result.moveToFirst()) {
            return helper.cursorToClient(result);
        }else{
            return new Client("not found","not found","not found");
        }
    }


}
