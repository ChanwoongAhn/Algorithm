import java.util.*;

public class NumOfZeroInCombination {
	public static Scanner sc = new Scanner(System.in);
	/*
	public static double factorial(int n) {
		if(n == 0)
			return 1;
		else if(n == 1)
			return 1;
		else
			return n*factorial(n-1);
	}
	*/
	public static double factorial(int n) {
		double result = 1;
		if (n == 1 || n == 0)
			result =  1;
		for(int i = 1; i <= n; i++)
			result *= i;
		return result;
	}

	public static double combination(int n, int m) {
		double numerator = 0;
		double denominator = 0;
		
		numerator = factorial(n) / factorial(n-m);
		denominator = factorial(m);
		
		return numerator / denominator;
	}
	public static void result(double num) {
		String tmp = num + "";
		String result = "";
		int sum = 0;
		/*
		for(int i = 0; i < tmp.length() - 1; i++) {
			if(tmp.charAt(i) == '.')
				break;
			else
				result = result + tmp.charAt(i);
		}
		System.out.println(result);
		for(int i = result.length() - 1; i > 0; i--) {
			if(result.charAt(i) == '0')
				sum ++;
			else
				break;
		}
		*/
		for(int i = tmp.length() - 3; i >= 0; i--) {
			if(tmp.charAt(i) == '0')
				sum ++;
			else
				break;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		result(combination(n,m));
	}

}
