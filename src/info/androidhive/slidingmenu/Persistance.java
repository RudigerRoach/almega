package info.androidhive.slidingmenu;

import android.content.Context;

import java.util.List;

/**
 * Created by rudiger on 2014/12/11.
 */
public class Persistance implements PersistanceInterface {

    private LocalStorage localStorage;

    public Persistance(Context context){
        localStorage = new LocalStorage(context);
    }

    @Override
    public void addClient(Client client) {
        if (isOnline()){

        }else{
            try {
                localStorage.open();
                localStorage.addClient(client);
                localStorage.close();
            }catch(Throwable e){
                System.out.println("cannot oped localstorage db: "+e.toString());
            }
        }
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
        Client client = null;
        if (isOnline()){

        }else{
            try {
                localStorage.openRO();
                client = localStorage.getClient(cell,name,surname);
                localStorage.close();
            }catch(Throwable e){
                System.out.println("cannot oped localstorage db: "+e.toString());
            }
        }
        return client;
    }

    private boolean isOnline(){
        //TODO: check connectivity to server
        return false;
    }
}
