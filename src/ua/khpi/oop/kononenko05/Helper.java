package ua.khpi.oop.kononenko05;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
	private ArrayList<String> storage = new ArrayList<String>();
	
	public static void Print_info() {
		System.out.println("Creator: Kononenko Dmytro");
		System.out.println("Group: 1.KIT 102.8a");
		System.out.println("Date: 01.11.2019");
	}
	
	public boolean Polindrom(final String arg_1,final String arg_2) {
		
		if(arg_1.length() != arg_2.length() | arg_1.equals("")) {
			return false;
		}
		
		for (int i = 0; i < arg_1.length(); i++) {
			char ch_1 = arg_1.charAt(i);
			char ch_2 = arg_2.charAt(arg_1.length() - 1 - i);
			if(ch_1 != ch_2) {
				return false;
			}
		}
		return true;
	}
	
	
	public void Parse(String parse_string){
		ArrayList<String> storage2 = new ArrayList<String>();
		String temp_storage;
		int temp = parse_string.indexOf(" ");
		temp++;
		while(parse_string.length() != 0) {
			
			temp_storage = new String(parse_string.substring(0,temp));
			temp_storage = temp_storage.trim();
			
			storage2.add(temp_storage);
			
			parse_string = new String(parse_string.substring(temp)); 
			
			temp = parse_string.indexOf(" ")+1;
			if(temp == 0) { // when the program trying to find last word
				
				temp = parse_string.length(); 
			
				}
			
			}
		
		
		storage = storage2;
	}
	
	public void  Print_result() {
		if(!storage.isEmpty()){
			System.out.println("------------------------------------------");
        	System.out.println("|     Word      |      Reverse word      |");
        	System.out.println("------------------------------------------");
			for(int i = 0; i <storage.size();i++) {
				for (int j = 0; j < storage.size(); j++) {
					if(Polindrom(storage.get(i),storage.get(j))) {
						System.out.println("|       " + storage.get(i) + "       |      " + storage.get(j) + "    |");
					}
				}
			}
		} else {
			System.out.println("String is empty!!");
		}
	}
	
	
	public static int  Settings() {
		int choose;
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("0 - Exit");
		System.out.println("1 - Insert data");
		System.out.println("2 - Show data");
		System.out.println("3 - Parse data");
		System.out.println("4 - Show result");
		System.out.println("Select: ");
		choose = in.nextInt();
		in.close();
		return choose;
	}
}
