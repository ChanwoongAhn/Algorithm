import java.util.*;

public class NumOfZeroInFactorial {
	public static Scanner sc = new Scanner(System.in);
	
	public static long factorial(int num) {
		if(num == 0)
			return 1;
		else if(num == 1)
			return 1;
		else
			return num*factorial(num-1);
	}
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		long result = factorial(n);
		String number = result + "";
		int sum = 0;
		
		for(int i = number.length() - 3; i > 0; i--) {
			char tmp = number.charAt(i);
			if(tmp == '0')
				sum ++;
			else if(tmp != '0')
				break;
		}
		System.out.println(sum);
	}
}
