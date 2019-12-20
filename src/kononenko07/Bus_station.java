package ua.khpi.oop.kononenko07;
import java.util.ArrayList;
import java.util.Date;

class MyDate{
	private int hours;
	private int minutes;
	
	public MyDate() {
		this.hours = 0;
		this.minutes = 0;
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
		return hours*60 + minutes;
	}
	
	public String toString() {
		String str = hours + ":" + minutes;
		return str;
	}
}

class Station{
	String Name;
	MyDate time;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String str) {
		this.Name = str;
	}
	
	public MyDate getTime() {
		return time;
	}
	
	public void setTime(MyDate time) {
		this.time = time;
	}
}

public class Bus_station {
	private int fli_num;
	private int free_sits;
	private MyDate time;
	private String days;
	ArrayList<Station> storage;
	
	public Bus_station() {
		time = new MyDate();
		storage = new ArrayList<Station>();
	}
	
	public void SetStations(ArrayList<Station> stp) {
		this.storage = stp;
	}
	
	public ArrayList<Station> getStation() {
		return storage;
	}
	
	public MyDate getTime() {
		return time;
	}
	public void setTime(MyDate depTime) {
		this.time = depTime;
	}
	public int getFli_num() {
		return fli_num;
	}
	public void setFli_num(int fli_num) {
		this.fli_num = fli_num;
	}
	public int getFree_sits() {
		return free_sits;
	}
	public void setFree_sits(int free_sits) {
		this.free_sits = free_sits;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}
	
}
