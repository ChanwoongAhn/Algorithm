import java.util.*;
public class Prob_6730 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int [] arr;
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			n = sc.nextInt();
			arr = new int[n];
			
			for(int i = 0; i < n; i ++)
				arr[i] = sc.nextInt();
			int max_inc = 0;
			int max_dec = 0;
			
			for(int i = 1; i < n; i ++) {
				if(arr[i] - arr[i-1] > max_inc)
					max_inc = arr[i] - arr[i-1];
				else if(-(arr[i] - arr[i-1]) > max_dec)
					max_dec = -(arr[i] - arr[i-1]);
			}
			System.out.println("#" + (order_label++) + " " +max_inc +" " + max_dec);
		}
	}
}
