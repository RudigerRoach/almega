package info.androidhive.slidingmenu;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by rudiger on 2014/12/19.
 */
public class Booking {
    private Client client;
    private Date fromDate;
    private Date toDate;
    private String stand;
    private LinkedList<String> requests;
    public Boolean isConfirmed, isPaidDeposit, isPaidComplete;

    public Booking(){
        isConfirmed = isPaidComplete = isPaidDeposit = false;
    }
    public Booking(Client client,Date fromDate,Date toDate,String stand){
        setClient(client);
        setFromDate(fromDate);
        setToDate(toDate);
        setStand(stand);
        isConfirmed = isPaidComplete = isPaidDeposit = false;
    }
    public Booking(Client client,Date fromDate,Date toDate,String stand,LinkedList<String> requests){
        setClient(client);
        setFromDate(fromDate);
        setToDate(toDate);
        setStand(stand);
        setRequests(requests);
        isConfirmed = isPaidComplete = isPaidDeposit = false;
    }

    //Setters
    public void setClient(Client client){
        this.client = client;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public void setStand(String stand) {
        this.stand = stand;
    }
    public void setRequests(LinkedList<String> requests) {
        this.requests = requests;
    }
    public void addRequest(String request){
        this.requests.add(request);
    }

    //Getters
    public Date getFromDate() {
        return fromDate;
    }
    public Client getClient() {
        return client;
    }
    public String getStand() {
        return stand;
    }
    public Date getToDate() {
        return toDate;
    }
    public LinkedList<String> getRequests() {
        return requests;
    }

}
