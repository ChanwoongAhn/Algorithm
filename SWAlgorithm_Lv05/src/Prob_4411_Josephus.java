import java.util.*;

public class Prob_4411_Josephus {
	public static Scanner sc = new Scanner(System.in);
	
	public static long getresult(long n, long k) {
		long result = 0;
		
		for(int i = 1; i < n+1; i++)
			result = (result + k) % i + 1;

		return result;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int test_label = 1;
		
		while(testcase -- > 0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			System.out.print("#" + (test_label++) + " ");
			System.out.println(getresult(n,k));
		}
	}
}
