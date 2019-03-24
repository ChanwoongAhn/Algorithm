import java.util.*;

public class Prob_3314 {
	public static Scanner sc = new Scanner(System.in);
	public static int [] arr = new int[5];
	
	public static int getAvg() {
		int avg = 0;
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 40)
				arr[i] = 40;
			avg += arr[i];
		}
		
		avg /= 5;
		
		return avg;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			System.out.println("#" + (order_label++) + " " +getAvg());
		}
	}
}
