package info.androidhive.slidingmenu;

import java.util.List;

/**
 * Created by rudiger on 2014/12/11.
 */
public interface PersistanceInterface {

    //client Management
    public void addClient(Client client);
    public void updateClient(Client client);
    public List<Client> getClients();
    public Client getClient(String cell, String name, String surname);
}
