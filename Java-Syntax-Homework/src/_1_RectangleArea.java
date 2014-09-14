import java.util.Scanner;

public class _1_RectangleArea {

	public static void main(String[] args) {
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first side of rectangle a = ");
		int firstSide = scan.nextInt();
		System.out.print("Enter second side of rectangle b = ");
		int secondSide = scan.nextInt();
		int area = firstSide * secondSide;
		System.out.print("Rectangle area = " + area);
	}

}
