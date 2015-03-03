package info.androidhive.slidingmenu.globalContext;

import android.content.Context;

/**
 * Created by rudiger.roach on 2015-03-03.
 */
public class contextSingleton {
    private static contextSingleton ourInstance = new contextSingleton();

    public static contextSingleton getInstance() {
        return ourInstance;
    }

    private contextSingleton() {
    }

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
