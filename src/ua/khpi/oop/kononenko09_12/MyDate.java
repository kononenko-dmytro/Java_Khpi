package ua.khpi.oop.kononenko09_12;

import java.io.Serializable;
import java.time.LocalTime;

public class MyDate implements Serializable {

    private int hours;
    private int minutes;

    private static final long serialVersionUID = 1L;

    public MyDate() {
    }

    public MyDate(int hs, int ms) {
        this.hours = hs;
        this.minutes = ms;
    }

    public MyDate(MyDate readObject) {
        this.hours = readObject.hours;
        this.minutes = readObject.minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int str) {
        this.hours = str;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int time) {
        this.minutes = time;
    }

    public int getToCompare() {
        return hours * 60 + minutes;
    }

    public String toString() {
        return LocalTime.of(hours, minutes).toString();
    }

}
