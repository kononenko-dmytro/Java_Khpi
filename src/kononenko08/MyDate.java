package ua.khpi.oop.kononenko08;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyDate implements Externalizable {
	private int hours;
	private int minutes;
	
	private static final long serialVersionUID = 1L;
	
	public MyDate() {
	}
	
	public MyDate(int hs,int ms) {
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
		return hours*60 + minutes;
	}
	
	public String toString() {
		String str = hours + ":" + minutes;
		return str;
	}

	@Override
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			setHours(in.readInt());
			setMinutes(in.readInt());
	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(this.getHours());
		out.writeObject(this.getMinutes());
	}
}