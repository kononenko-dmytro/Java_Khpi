package ua.khpi.oop.kononenko04;

import java.util.ArrayList;
import java.util.Scanner;

public class main{
	
	public static void main(final String[] arg){ //main point 
		int choose;
		Scanner in = new Scanner(System.in);
		ArrayList<String> storage = new ArrayList<String>();
		StringBuffer string_1 = null;
		boolean flag = false; 
		
		for(String temp : arg) {
			if(temp.equals("-h")|| temp.equals("-help")) {
				Helper.Print_info();
			}
		}
		
		for(String temp : arg) {
			if(temp.equals("-d")|| temp.equals("-debug")) {
				flag = true;
			}
		}
		
		if(flag) {
		
		choose = Helper.Settings();
		
		while(choose != 0){
			
			switch(choose) {
			case 1:
				string_1 = new StringBuffer(in.nextLine());
				break;
			case 2: 
				if(storage.isEmpty()) {
					System.out.println("No data in storage");
				} else {
					for (String it : storage) {
						System.out.println(it);
					}
				}
				break;
			case 3:
				if(string_1.length() == 0) {
					System.out.println("No data in storage");
				} else {
					storage = Helper.Parse(string_1);
				}
				break;
			case 4:
				Helper.Print_result(storage);
				break;
			default:
				break;
			}
			
			choose = Helper.Settings();
		}
		} else {
			System.out.println("Input data: ");
			string_1 = new StringBuffer(in.nextLine());
			storage = Helper.Parse(string_1);
			Helper.Print_result(storage);
		}
	}	
}