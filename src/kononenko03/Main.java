package ua.khpi.oop.kononenko03;
import java.util.ArrayList;
import java.util.Scanner;


public class Main{
	public static boolean Polindrom(String arg_1,String arg_2) {
		
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
	
	
	public static ArrayList<String> Parse(StringBuffer parse_string){
		ArrayList<String> storage = new ArrayList<String>();
		String temp_storage;
		int temp = parse_string.indexOf(" ");
		while(parse_string.length() != 0) {
			
			temp_storage = new String(parse_string.substring(0,temp));
			temp_storage = temp_storage.trim();
			
			storage.add(temp_storage);
			
			parse_string = new StringBuffer(parse_string.substring(temp)); 
			
			temp = parse_string.indexOf(" ")+1;
			if(temp == 0) { // when the program trying to find last word
				
				temp = parse_string.length(); 
			
				}
			
			}
		
		
		return storage;
	}
	
	
	public static void main(String arg[]){ //main point 
		Scanner in = new Scanner(System.in);
		ArrayList<String> storage = new ArrayList<String>();
		StringBuffer string_1 = new StringBuffer(in.nextLine());
		
		storage = Parse(string_1);
		
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
		
	}	
}