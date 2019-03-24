import java.util.*;

public class Prob_5688 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			long num = sc.nextLong();
			long result = -1;
			
			for(int i = (int)Math.sqrt(Math.sqrt(num)); i < Math.sqrt(num); i ++) {
				if(i*i*i == num) {
					result = i;
					break;
				}
			}
			System.out.println("#" + (order_label++) + " " + result);
		}
	}
}
