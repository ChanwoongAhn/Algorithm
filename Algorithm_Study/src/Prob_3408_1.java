import java.util.*;

public class Prob_3408_1 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void sumofnum(int n) {
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		int k = 1;
		
		while(n > 0) {
			s1 += n;
			s2 += k;
			s3 += k+1;
			k += 2;
			n--;
		}
		System.out.println(s1 + " " + s2 + " " + s3);
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num-- > 0) {
			int n = sc.nextInt();
			System.out.print("#" + (order_label++) + " ");
			sumofnum(n);
		}
	}
}
