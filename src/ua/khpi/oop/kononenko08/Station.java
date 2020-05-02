package ua.khpi.oop.kononenko08;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Station implements Externalizable {
	String name;
	MyDate time;
	
	private static final long serialVersionUID = 1L;
	
	public Station(Station readObject) {
		this.name = readObject.name;
		this.time = readObject.time;
	}

	public Station() {
		name = new String();
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
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		setName((String)in.readObject());
		setTime((MyDate)in.readObject());
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(getName());
		out.writeObject(getTime());
	}
}