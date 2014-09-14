import java.util.Scanner;

public class SumTwoNumbers {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first integer number:");
		int firstNumber = scan.nextInt();	
		System.out.print("Enter second integer number:");
		int secondNumber = scan.nextInt();	
		int sum = firstNumber + secondNumber;
		System.out.println(sum);
		System.out.println("\u2B25");
		scan.close();
	}
}

