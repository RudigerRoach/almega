package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rudiger on 2014/12/11.
 */
public class Logic implements LogicInterface{
    private static Logic instance;
    private Context context;
    private Persistance persistanceService;

    //temp storage for independant testing
    private LinkedList<Client> clients;
    private int clientIdCounter = 0;
    private LinkedList<Booking> bookings;

    //Make Logic a singleton
    private Logic(Context context){
        this.context = context;
        this.persistanceService = new Persistance(context);
        this.clients = new LinkedList<Client>();
    }
    private Logic(){
        this.clients = new LinkedList<Client>();
    }

    public static Logic getInstance(){
        if (instance == null){
            instance = new Logic();
        }
        return instance;
    }


    public void addClient(Client client){
        //Temporary implementation
        client.setId((long)(clientIdCounter++));
        clients.add(client);
        //persistanceService.addClient(client);
    }
    public void updateClient(Client client){
        //Temporary implementation
        for (Client c : clients){
            if(c.getId() == client.getId()){
                c.update(client);
            }
        }
    }
    @Override
    public List<Client> getClients() {
        //Temporary implementation
        List<Client> temp =new LinkedList<Client>();
        for (Client c : clients){
            temp.add(c.clone());
        }
        return temp;
    }

    public List<Client> getClients(String name, String surname, String cell) {
        //TODO: swap dummy with real return values
        List<Client> clientList = getClients();
        List<Client> returnClientList = new LinkedList<Client>();

        for(Client c : clientList){
            if(c.getName().contains(name) && c.getSurname().contains(surname) && c.getCell().contains(cell)){
                returnClientList.add(c);
            }
        }
        return clientList;
    }

    @Override
    public Client getClient(String cell, String name, String surname) {
        for(Client c : clients){
            if ((c.getCell()).compareTo(cell) == 0 && (c.getName()).compareTo(name) == 0 && (c.getSurname()).compareTo(surname) == 0)
                return c.clone();
        }
        return null;
        //return persistanceService.getClient(cell,name,surname);
    }


    public void notify(String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
    public void setContext(Context c){
        context = c;
    }
}
