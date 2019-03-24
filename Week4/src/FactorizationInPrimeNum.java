import java.util.*;

public class FactorizationInPrimeNum {
	public static Scanner sc = new Scanner(System.in);
	public static int [] arr = new int[10000];
	
	public static void MakePrimeNum() {
		int n = 2;
		int k = 0;
		while(n < 10000) {
			boolean flag = true;
			for(int i = 2; i <= Math.sqrt(n); i++) {
				if(n % i == 0)
					flag = false;
			}
			if(flag)
				arr[k++] = n;
			n++;
		}
	}
	public static boolean isPrime(int num) {
		boolean flag = true;
		
		if(num == 1)
			flag = false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				flag = false;
		}
		return flag;
	}
	public static void factorization(int num) {
		int position = 0;
		
		while(num > 1) {
			if(isPrime(num)) {
				System.out.println(num);
				break;
			}
			else if(num % arr[position] == 0) {
				num = num / arr[position];
				System.out.println(arr[position]);
			}
			else
				position ++;
		}
	}
	public static void main(String[] args) {
		int num = sc.nextInt();
		MakePrimeNum();
		factorization(num);
	}

}
