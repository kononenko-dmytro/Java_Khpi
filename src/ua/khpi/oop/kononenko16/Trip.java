package ua.khpi.oop.kononenko16;

import java.io.Serializable;
import java.util.ArrayList;

public class Trip implements Serializable,Comparable<Trip>{

    private int sits;
    private MyDate departure;
    private String days;
    private String numTrip;
    public ArrayList<Station> storage;

    private static final long serialVersionUID = 1L;

    public ArrayList<Station> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<Station> storage) {
        this.storage = storage;
    }


    public String getNumTrip() {
        return numTrip;
    }

    public Trip() {
        departure = new MyDate();
        storage = new ArrayList<Station>();
    }

    public Trip(int sits,String days){
        this.sits = sits;
        this.days = days;
    }

    public Trip(Trip readObject) {
        this.numTrip = readObject.numTrip;
        this.days = readObject.days;
        this.sits = readObject.sits;
        this.departure = readObject.departure;
        this.storage = readObject.storage;
    }

    public void setNumTrip(String numTrip) {
        this.numTrip = numTrip;
    }

    public int getSits() {
        return sits;
    }

    public void setSits(int sits) {
        this.sits = sits;
    }

    public MyDate getDeparture() {
        return departure;
    }

    public void setDeparture(MyDate departure) {
        this.departure = departure;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String toString() {

        StringBuilder test = new StringBuilder("Number of trip: " + this.numTrip + "\nNumber of sits: " +
                this.sits + "\nWorking days: " +
                this.days + "\nTime of department: " +
                this.departure.toString() + "\n");

        for (Station s : storage) {
            test.append("Station: \n" + s.toString() + "\n");
        }

        return test.toString();
    }


    @Override
    public int compareTo(Trip o) {
        return Integer.compare(this.sits,o.sits);
    }
}
