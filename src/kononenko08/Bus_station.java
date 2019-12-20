package ua.khpi.oop.kononenko08;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;




import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

import javax.rmi.CORBA.Util;


public class Bus_station implements Externalizable {
	private int fli_num;
	private int free_sits;
	private MyDate time;
	private String days;
	public ArrayList<Station> storage;
	
	private static final long serialVersionUID = 1L;
	
	public Bus_station() {
		time = new MyDate();
		storage = new ArrayList<Station>();
	}
	
	public Bus_station(Bus_station readObject) {
		this.fli_num = readObject.fli_num;
		this.time = readObject.time;
		this.free_sits = readObject.free_sits;
		this.days = readObject.days;
		this.storage = readObject.storage;
	}

	public void setStations(ArrayList<Station> stp) {
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

	@SuppressWarnings("unchecked")
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		fli_num = in.readInt();
		free_sits = in.readInt();
		days = (String) in.readObject();
		time = ((MyDate)in.readObject());
		storage = ((ArrayList<Station>)in.readObject());
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeObject(getFli_num());
		out.writeObject(getFree_sits());
		out.writeObject(getTime());
		out.writeObject(getDays());
		out.writeObject(getStation());
	}
	
}
