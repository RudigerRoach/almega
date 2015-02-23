package info.androidhive.slidingmenu;

import android.database.Cursor;
import org.w3c.dom.Comment;

/**
 * Created by rudiger on 2014/12/11.
 */
public class Client {
    public Client(){}
    public Client(String name, String surname, String cell){
        setName(name);
        setSurname(surname);
        setCell(cell);
    }
    public Client(String name, String surname, String cell,String vehicle, String comment, String email){
        setName(name);
        setSurname(surname);
        setCell(cell);
        setComment(comment);
        setVehicle(vehicle);
        setEmail(email);
    }

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String cell;
    private String vehicle;
    private String comment;
    boolean hasChanged = false;




    @Override
    public String toString(){
        return name+" "+surname+" "+cell+" "+email+" "+vehicle+" "+comment;
    }

    public String toShortString(){
        return cell+" | "+name+" | "+surname;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public boolean isHasChanged() {
        return hasChanged;
    }

    public String getCell() {
        return cell;
    }

    public String getComment() {
        return comment;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getVehicle() {
        return vehicle;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    void setCell(String cell) {
        this.cell = cell;
    }

    void setComment(String comment) {
        if (comment != null ) {
            this.comment = comment;
        }
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    //other functions
    public void update(Client other){
        if (comment != other.getComment()) comment = other.getComment();
        if(email != other.getEmail()) email = other.getEmail();
        if (name != other.getName()) name = other.getName();
        if(surname != other.getSurname()) surname = other.getSurname();
        if (vehicle != other.getVehicle()) vehicle = other.getVehicle();
        if(cell != other.getCell())  cell = other.getCell();
    }
    public Client cursorToClient(Cursor cursor) {
        Client client = new Client();
        client.id = cursor.getLong(0);
        client.comment = cursor.getString(1);
        client.vehicle = cursor.getString(2);
        client.email = cursor.getString(3);
        client.cell = cursor.getString(4);
        client.surname = cursor.getString(5);
        client.name = cursor.getString(6);

        return client;
    }

    public Client clone(){
        Client newClient = new Client();
        newClient.setId(this.id);
        newClient.setEmail(this.email);
        newClient.setVehicle(this.vehicle);
        newClient.setComment(this.comment);
        newClient.setCell(this.cell);
        newClient.setName(this.name);
        newClient.setSurname(this.surname);
        return newClient;
    }

}
