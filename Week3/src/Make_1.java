import java.util.*;

public class Make_1 {
	public static Scanner sc = new Scanner(System.in);
	public static int [] d;
	public static int dp(int n) {
		if(n == 1)
			return 0;
		
		if(d[n] > 0)
			return d[n];
		
		d[n] = dp(n-1) + 1;
		
		if(n % 3 == 0)
			d[n] = Math.min(d[n], dp(n/3) + 1);
		if(n % 2 == 0)
			d[n] = Math.min(d[n], dp(n/2) + 1);
		
		return d[n];
	}
	public static void main(String[] args) {
		int num = sc.nextInt();
		d = new int[num+1];
		
		System.out.println(dp(num));
	}
}
