package info.androidhive.slidingmenu;

import java.util.List;

/**
 * Created by rudiger on 2014/12/11.
 *
 * This interface exists purely to de-couple the business logic from the UI
 */
public interface LogicInterface {

    //Client manipulation functions
    public void addClient(Client client);
    public void updateClient(Client client);
    public List<Client> getClients();
    public Client getClient(String cell, String name, String surname);

    //Booking manipulation functions

}
