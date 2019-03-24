import java.util.*;

public class BaseConversion {
	public static Scanner sc = new Scanner(System.in);
	public static void convert(int a, int b) {
		int size_num = sc.nextInt();
		int [] arr = new int[size_num];
		int decimal_a = 0;
		String result = "";
		
		while(size_num-- >0 ) {
			arr[size_num] = sc.nextInt();
		}
		size_num = arr.length;
		
		while(size_num-- > 0) {
			int tmp = size_num;
			int sum = arr[size_num];
			while(tmp-- > 0)
				sum = a*sum;
			if(size_num == 0)
				decimal_a += arr[size_num];
			else
				decimal_a = decimal_a + sum;
		}
		result = decimal_a % b + "";
		decimal_a = decimal_a / b;
		while(decimal_a >= b) {
			result = decimal_a % b + " " + result;
			decimal_a = decimal_a / b;
		}
		result = decimal_a + " " + result;
		System.out.println(result);
	}
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		convert(a,b);
	}
}
