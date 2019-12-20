package ua.khpi.oop.kononenko07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main_07 {
	
	public static void Settings() {

		System.out.println();
		System.out.println("0 - Exit");
		System.out.println("1 - Insert data");
		System.out.println("2 - Show data");
		System.out.println("3 - Add entry to schedule");
		System.out.println("4 - delete selected");
		System.out.println("5 - clear array");
		System.out.println("Select: ");

	}
	
	public static void main(final String[] arg) {
		System.setProperty("console.encoding","Cp866");
		int choose;
		int num;
		int num2;
		Station a;
		MyDate now;
		Bus_station tm_st; 
		ArrayList<Station> temp;
		ArrayList<Bus_station> test = new ArrayList<Bus_station>();
		Scanner in = new Scanner(System.in);
		
		Settings();
		choose = in.nextInt();
		
		while(choose != 0) {
			
			switch(choose) {
			case 1:
				System.out.println("Input number of passages: ");
				num = in.nextInt();
				
				for (int i = 0; i < num; i++) {
					
					tm_st = new Bus_station();
					now = new MyDate();
					temp = new ArrayList<Station>();
					
					System.out.println("Input number of passage: ");
					tm_st.setFli_num(in.nextInt());
					System.out.println("Input number of sits: ");
					tm_st.setFree_sits(in.nextInt());
					System.out.println("Input working days: ");
					tm_st.setDays(in.next());
					System.out.println("Input time of departure: ");
					System.out.println("Input hour: ");
					now.setHours(in.nextInt());
					System.out.println("Input minutes");
					now.setMinutes(in.nextInt());
					tm_st.setTime(now);
					
					System.out.println("Input number of stations: ");
					num2 = in.nextInt();
					
					for(int j = 0; j<num2 ; j++) {
						a = new Station();
						now = new MyDate();
						System.out.println("Input name of the station: ");
						a.setName(in.next());
						System.out.println("Input time of arrival: ");
						System.out.println("Input hour: ");
						now.setHours(in.nextInt());
						System.out.println("Input minutes");
						now.setMinutes(in.nextInt());
						a.setTime(now);
						temp.add(a);
					}
					tm_st.SetStations(temp);
					test.add(tm_st);
				}
				break;
			case 2: 
				
				for(int i = 0; i < test.size();i++) {
					System.out.println("Number of passage: " + test.get(i).getFli_num());
					System.out.println("Number of sits: " + test.get(i).getFree_sits());
					System.out.println("Input working days: " + test.get(i).getDays());
					System.out.println("Time of departure: " + test.get(i).getTime().toString());
					System.out.println(" \nStation and time: ");
					for(int j =0 ; j < test.get(i).getStation().size() ; j++) {
						System.out.println(test.get(i).getStation().get(j).getName() + " " + test.get(i).getStation().get(j).getTime().toString());
					}
					System.out.print("\n");
				}
				
				break;
			case 3:
				
				tm_st = new Bus_station();
				now = new MyDate();
				temp = new ArrayList<Station>();
				System.out.println("Input number of passage: ");
				tm_st.setFli_num(in.nextInt());
				System.out.println("Input number of sits: ");
				tm_st.setFree_sits(in.nextInt());
				System.out.println("Input working days: ");
				tm_st.setDays(in.next());
				System.out.println("Input time of departure: ");
				System.out.println("Input hour: ");
				now.setHours(in.nextInt());
				System.out.println("Input minutes");
				now.setMinutes(in.nextInt());
				tm_st.setTime(now);
				
				System.out.println("Input number of stations: ");
				num2 = in.nextInt();
				
				for(int j = 0; j<num2 ; j++) {
					a = new Station();
					now = new MyDate();
					System.out.println("Input name of the station: ");
					a.setName(in.next());
					System.out.println("Input time of arrival: ");
					System.out.println("Input hour: ");
					now.setHours(in.nextInt());
					System.out.println("Input minutes");
					now.setMinutes(in.nextInt());
					a.setTime(now);
					temp.add(a);
				}
				tm_st.SetStations(temp);
				
				test.add(tm_st);
				
				break;
			
			case 4:
				if(!test.isEmpty()) {
				System.out.println("Input number of note: ");
				num = in.nextInt();
				test.remove(num);
				} else {
					System.out.println("Error: arr is empty");
				}
				
				break;
			case 5:
				if(!test.isEmpty()) {
					test.clear();
					
				} else {
					System.out.println("Error: arr is empty");
				}
				
				break;
			
			default:
				break;
			}
			
			Settings();
		    choose = in.nextInt();
		}

	}
}
