import java.util.*;
public class GCDandMCM {
	public static Scanner sc = new Scanner(System.in);
	
	public static int GCD(int x, int y) {
		int remainder = x%y;
		int temp = 0;
		
		if(x < y) {
			temp = x;
			x = y;
			y = temp;
		}
		
		while(remainder > 0) {
			remainder = x%y;
			x = y;
			y = remainder;
		}
		return x;
	}
	public static int MCM(int x, int y, int gcd) {
		return x*y/gcd;
	}
	public static void main(String[] args) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println(GCD(x,y));
		System.out.println(MCM(x,y,GCD(x,y)));
	}
}
