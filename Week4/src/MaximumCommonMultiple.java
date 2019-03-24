import java.util.*;

public class MaximumCommonMultiple {
	public static Scanner sc = new Scanner(System.in);
	
	public static void MCM(int x, int y) {
		int remainder = 1;
		int temp = 0;
		if(x < y) {
			temp = x;
			x = y;
			y = temp;
		}
		int val1 = x;
		int val2 = y;
		
		while(remainder > 0) {
			remainder = val1%val2;
			val1 = val2;
			val2 = remainder;
		}
		System.out.println(x*y/val1);
	}
	public static void main(String[] args) {
		int order = sc.nextInt();
		
		while(order -- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			MCM(x,y);
		}
	}
}
