import java.util.*;

public class GoldbachAssumption {
	public static Scanner sc = new Scanner(System.in);
	public static int [] arr = new int[1000];
	public static void makeprimearr() {
		int n = 3;
		int k = 0;
		
		while(n < 1000) {
			boolean flag = true;
			for(int i = 2; i <= Math.sqrt(n); i++) {
				if(n % i == 0)
					flag = false;
			}
			if(flag == true) {
				arr[k] = n;
				k++;
			}
			n++;
		}
	}
	public static boolean isPrime(int n) {
		boolean flag = true;
		if(n == 1)
			flag = false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0)
				flag = false;
		}
		return flag;
	}
	public static String MakeResult(int num1, int num2) {
		return (num1+num2) + " = " + num1 + " + " + num2;
	}
	public static void Goldbach(int num) {
		String result;
		int k = 0;
		int tmp = 0;
		while(true) {
			tmp = num;
			num -= arr[k];
			if(isPrime(num)) {
				result = MakeResult(arr[k], num);
				break;
			}
			else if(num <= 1) {
				result = "Goldbach's conjecture is wrong.";
			}
			else {
				num = tmp;
				k++;
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		makeprimearr();
		
		while(sc.hasNextInt() == true) {
			int num = sc.nextInt();
			if(num == 0)
				break;
			else
				Goldbach(num);
		}
	}
}
