package ua.khpi.oop.kononenko05;

public class main_5{
	public static void main(final String[] arg){
		Helper tester4 = new Helper();
		String tester3;
		String tester2[];
		String tester[] = {"Hello it is me mario and oiram",
				"It is gonna be hot here si","We should find better place",
				"Oh hello there olleh"
		};
	
		Colection test = new Colection(tester);
		System.out.println("To string: ");
		tester3 = test.toString();
		
		System.out.println(tester3);
		
		
		System.out.println("To array: ");
		
		tester2 = test.toArray();
		
		for(String str : tester2) {
			System.out.println(str);
		}
		
		
		System.out.println(test.getElement(1));
		tester4.Parse(test.getElement(1));
		tester4.Print_result();
	}
}
