package ua.khpi.oop.kononenko01;

public class Main {
	public static int Even(long arg_1) {
		int res = 0;
		long temp;
		while(arg_1 !=0) {
			temp = arg_1 % 10;
			arg_1 = arg_1 / 10;
			if(temp % 2 == 0 && temp != 0) {
				res++;
			}
		}
		return res;
	}
	
	public static int Even(int arg_1) {
        int res = 0;
        int temp;
        while(arg_1 !=0) {
			temp = arg_1 % 10;
			arg_1 = arg_1 / 10;
			if(temp % 2 == 0 && temp != 0) {
				res++;
			}
		}
		return res;
	}
	
	public static int Odd(long arg_1) {
		int res = 0;
		long temp;
		while(arg_1 !=0) {
			temp = arg_1 % 10;
			arg_1 = arg_1 / 10;
			if(temp % 2 != 0 && temp != 0) {
				res++;
			}
		}
		return res;
	}
	public static int Odd(int arg_1) {
		int res = 0;
		int temp;
		while(arg_1 !=0) {
			temp = arg_1 % 10;
			arg_1 = arg_1 / 10;
			if(temp % 2 != 0 && temp != 0) {
				res++;
			}
		}
		return res;
	}
	
	public static int BinaryCal(int arg) {
		String temp = Integer.toBinaryString(arg);
		char one;
		int res = 0;
		for(int i = 0;i < temp.length();i++) {
			one = temp.charAt(i);
			if(one == '1') {
				res++ ; 
			}
		}
		
		return res;
	}
	
	public static int BinaryCal(long arg) {
		String temp = Long.toBinaryString(arg);
		char one;
		int res = 0;
		for(int i = 0;i < temp.length();i++) {
			one = temp.charAt(i);
			if(one == '1') {
				res++ ; 
			}
		}
		
		return res;
	}
	
	public static void main(String[] arg) {
		final int Zalik = 0x4675;
		long Number = 380979361593L;
		final int Binary = 0b1011101;
		final int Octal = 03071;
		int Zalishok = ((8-1)%26)+1;
		char Magick = 72;
		
		System.out.println("Student`s record book: " + Zalik);
		System.out.println("Phonenumber: " + Number);
		System.out.println("Last two symboles in binary: " + Binary);
		System.out.println("Last four symboles in octal:" + Octal);
		System.out.println("Number of student in the list: " + Zalishok);
		System.out.println("Symbole of alphabet: " + Magick);
		System.out.println("Number of even numbers: " + Even(Magick));
		System.out.println("Number of odd numbers: " + Odd(Number));
		System.out.println("Number of '1' in number: " + BinaryCal(Number));
	}
}
