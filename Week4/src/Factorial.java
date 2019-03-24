import java.util.*;

public class Factorial {
	public static Scanner sc = new Scanner(System.in);
	
	public static int factorial(int n) {
		if(n == 0)
			return 1;
		else if(n == 1)
			return 1;
		else
			return n*factorial(n-1);
	}
	public static void main(String[] args) {
		int num = sc.nextInt();

		System.out.println(factorial(num));
	}
}
