package ua.khpi.oop.kononenko02;
import java.util.Random;

public class Main {
	public static void func() {
		System.out.println("-----------------------------");
	    System.out.println("|  Number  |   Odd    | Even |");
	    System.out.println("-----------------------------");
		Random Number = new Random();
		for(int x = 0;x<10;x++) {
		int resEven = 0;
		int resOdd = 0;
		int temp;
		int num = Number.nextInt(9999999 + 1);
		
		System.out.print("| " + num + "  |" );
		
		while(num !=0) {
			temp = num % 10;
			num = num / 10;
			if(temp % 2 == 0 && temp != 0) {
				resEven += temp;
			}else {
				resOdd += temp;
			}
		}
		
	      System.out.print("   " + resOdd+ "  |  " + resEven + "  |\n");
	      System.out.print("-----------------------------\n");
		}
		
		  
	}
	public static void main(String arg[]) {
		func();
	}
}
