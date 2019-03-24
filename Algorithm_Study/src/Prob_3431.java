import java.util.*;

public class Prob_3431 {
	public static Scanner sc = new Scanner(System.in);
	
	public static int exercise_management() {
		int l = sc.nextInt();
		int u = sc.nextInt();
		int x = sc.nextInt();
		
		if(x < l)
			return l-x;
		else if(x > u)
			return -1;
		else
			return 0;
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num-- > 0) {
			System.out.println("#" +(order_label++) + " " +exercise_management());
		}
	}
}
