import java.util.*;

public class Prob_3376 {
	public static Scanner sc = new Scanner(System.in);
	public static long [] arr;
	public static long padovansequence(int n) {
	/*
		if(n == 1)
			return 1;
		else if(n == 2)
			return 1;
		else if(n == 3)
			return 1;
		else if(n == 4)
			return 2;
		else if(n == 5)
			return 2;
		else
			return padovansequence(n-1) + padovansequence(n-5);
	*/
		arr = new long[n];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;
		for(int i = 5; i < n; i++)
			arr[i] = arr[i-1] + arr[i-5];
		
		return arr[n-1];
	}
	
	
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num -- > 0) {
			int n = sc.nextInt();
			System.out.println("#" + (order_label ++) + " " + padovansequence(n));
		}

	}

}
