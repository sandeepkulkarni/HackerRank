package hackerrank.contests.indeedprime;

import java.util.Scanner;

public class Soyuz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		System.out.println("  /\\  ");
		
		for(int i=0; i<size;i++){
			printHead();
		}
		
		System.out.println(" /||\\ ");
		System.out.println("/:||:\\");
		
		for(int i=1; i<size;i++){
			printBase();
		}
		
		System.out.println("|/||\\|");
		System.out.println("  **  ");
		System.out.println("  **  ");
		
		
		s.close();
	}
	
	private static void printHead(){
		System.out.println("  ||  ");
	}
	private static void printBase(){
		System.out.println("|:||:|");
	}

}
