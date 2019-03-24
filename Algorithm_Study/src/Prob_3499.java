import java.util.*;

public class Prob_3499 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void perfectshuffle() {
		int testnum = sc.nextInt();
		String [] arr = new String[testnum];
		
		for(int i = 0; i < testnum; i += 2) {
			arr[i] = sc.next();
		}
		for(int i = 1; i < testnum; i += 2)
			arr[i] = sc.next();
		
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num -- > 0) {
			System.out.print("#" + (order_label ++) + " ");
			perfectshuffle();
		}
	}
}
