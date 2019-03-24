import java.util.*;

public class Prob_3456 {
	public static Scanner sc = new Scanner(System.in);
	
	public static int search_rectangle_size() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a == b)
			return c;
		else if(a == c)
			return b;
		else
			return a;
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order_label = 1;
		
		while(testcase_num-- > 0) {
			System.out.println("#" +(order_label++) + " " + search_rectangle_size());
		}

	}

}
