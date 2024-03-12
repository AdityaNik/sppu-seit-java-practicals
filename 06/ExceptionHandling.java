/*
 * Name: Aditya Nikam
 * Roll: 3098
 * Problem Statement: Implement a program to handle ArithmeticException, ArrayIndexoutBoundsException and NumberFormatException.
 * 		if num1 and num2 are not integer then the program would throw NumberFormatException, if num2 is 0 then throw ArithmeticException,
 * 		and if any index larger than length array is access then throw ArrayIndexoutBoundsException
 */

import java.util.Scanner;

public class ExceptionHandling {
	public static void main(String[] arr) {
		int num1, num2;
		int[] nums = { 10, 20, 30, 40, 50 };

		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("\nEnter two numbers: ");
				num1 = Integer.parseInt(sc.next());
				num2 = Integer.parseInt(sc.next());

				int c = num1 / num2;
				System.out.println("\nDivision is : " + c);

				System.out.println("\nEnter index of element you want (Size is 5)- ");
				int ind = sc.nextInt();
				System.out.println("\nElement is : " + nums[ind]);
			} catch (NumberFormatException nfe) {
				System.err.println(nfe);
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.err.println(aiobe);
			} catch (ArithmeticException ae) {
				System.err.println(ae);
			}
		}
	}
}
