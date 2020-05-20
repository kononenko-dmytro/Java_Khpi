package ua.khpi.oop.kononenko16;

import java.io.Serializable;

public class Station implements Serializable {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private String name;
    private MyDate time;

    private static final long serialVersionUID = 1L;

    public Station(Station readObject) {
        this.name = readObject.name;
        this.time = readObject.time;
    }

    public Station(String name, MyDate time) {
        this.name = name;
        this.time = time;
    }

    public Station() {
        time = new MyDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public MyDate getTime() {
        return time;
    }

    public void setTime(MyDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Name: "  + getName()
                + " Arrival: " + getTime().toString();
    }

}
