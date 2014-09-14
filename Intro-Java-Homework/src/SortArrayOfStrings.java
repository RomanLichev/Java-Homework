
import java.util.Scanner;
import java.util.Arrays;

public class SortArrayOfStrings {

	public static void main(String[] args) {
		System.out.print("Enter integer number:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String[] word = new String[num];
		for (int i = 0; i < num; i++) {
		word[i] = input.next();
		}
		input.close();
		Arrays.sort(word);
		for (String string : word) {
			System.out.println(string);
		}
	}
}
