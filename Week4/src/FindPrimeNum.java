import java.util.*;

public class FindPrimeNum {
	public static Scanner sc = new Scanner(System.in);
	
	public static void PrimeNum(int a, int b) {
		int n = a;
		while(n <= b) {
			boolean flag = true;
			if(n == 1)
				flag = false;
			for(int i = 2; i <= Math.sqrt(n); i++) {
				if(n % i == 0)
					flag = false;
			}
			if(flag == true)
				System.out.println(n);
			n++;
		}
	}
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		PrimeNum(a,b);
	}
}
