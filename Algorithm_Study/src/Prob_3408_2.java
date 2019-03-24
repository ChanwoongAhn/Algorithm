import java.util.*;

public class Prob_3408_2 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void sumofnum(long n) {
		long s1 = n*(n+1)/2;
		long s2 = n*n;
		long s3 = n*(n+1);
		
		System.out.println(s1 + " " + s2 + " " + s3);
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num -- > 0) {
			long n = sc.nextLong();
			System.out.print("#" + (order_label++) + " ");
			sumofnum(n);
		}
	}
}
