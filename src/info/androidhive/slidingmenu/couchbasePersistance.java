package info.androidhive.slidingmenu;

import android.content.Context;
import android.util.Log;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import info.androidhive.slidingmenu.Exceptions.globalContextNotSetException;
import info.androidhive.slidingmenu.globalContext.contextSingleton;

import java.io.IOException;
import java.util.List;

/**
 * Created by rudiger.roach on 2015-03-03.
 */
public class CouchbasePersistance implements PersistanceInterface {
    private  Manager manager;
    private Context context;
    private final String TAG = "couchbase internal";

    public CouchbasePersistance() throws Exception {
        context = contextSingleton.getInstance().getContext();
        if (context == null){
            throw new globalContextNotSetException();
        }

        // create a manager
        try {
            manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            Log.d(TAG, "Manager created");
        } catch (IOException e) {
            Log.e(TAG, "Cannot create manager object");
            return;
        }
    }
    @Override
    public void addClient(Client client) {

    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public List<Client> getClients() {
        return null;
    }

    @Override
    public Client getClient(String cell, String name, String surname) {
        return null;
    }
}
