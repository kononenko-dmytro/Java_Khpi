package ua.khpi.oop.kononenko06;

import ua.khpi.oop.mishchenko06.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class main_06{
	public static void main(final String[] arg) throws IOException, ClassNotFoundException{
		int choose;
		int index;
		Colection test = new Colection();
		Helper parser = new Helper();
		String fill = new String();
		Scanner in = new Scanner(System.in);
		
		choose = Helper.Settings();
		
		while(choose != 0) {
			
			switch(choose) {
			case 1:
				System.out.println("Input new string: ");
				fill = in.nextLine();
				test.add(fill);
				break;
			case 2: 
				
				if(!test.isempty()) {
					for(int i = 0; i< test.size(); i++) {
						System.out.println(test.getElement(i));
					}
				}
				
				break;
			case 3:
				
				if(!test.isempty()) {
					System.out.println("Choose string to be used(int): ");
					
					index = in.nextInt();
					
					parser.Parse(test.getElement(index));
					parser.Print_result();
				}
				
				break;
			
			case 4:
				if(!test.isempty()) {
					FileOutputStream fileOutputStream = new FileOutputStream("D:/test2.txt");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				
					objectOutputStream.writeObject(test);
					objectOutputStream.close();
				}
				break;
			case 5:
				
				FileInputStream fileInputStream = new FileInputStream("D:/test.txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				
				test = (Colection) objectInputStream.readObject();
				objectInputStream.close();
				
				break;
			case 6:
				if(!test.isempty()) {
					test.sort();
				}
				break;
			case 7:
				if(!test.isempty()) {
					System.out.println("Input string to search: ");
					fill = in.nextLine();
					index = test.search(fill);
					if(index == -1) {
						System.out.println("Error: no such element");
					} else {
						System.out.println("Index of string: " + index);
					}
				}
				break;
			default:
				break;
			}
			
			choose = Helper.Settings();
		}
		in.close();
		
		IOClass.printInfo();
	}
}
