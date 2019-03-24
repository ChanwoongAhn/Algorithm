import java.util.*;
import java.math.BigInteger;

public class Prob_3812 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int n = sc.nextInt();
			
			BigInteger [] arr = new BigInteger[n];
			
			for(int i = 0; i < n; i ++)
				arr[i] = BigInteger.ZERO;
			
			for(int i = 0; i < x; i++)
				for(int j = 0; j < y; j++)
					for(int k = 0; k < z; k++) {
						int tmp = Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c);
						tmp = tmp%n;
						arr[tmp] = arr[tmp].add(BigInteger.ONE);
					}
			System.out.print("#" + (order_label++) + " ");
			for(int s = 0; s < n; s ++) {
				if(s == 0)
					System.out.print(arr[s]);
				else
					System.out.print(" " +arr[s]);
			}
			System.out.println();
		}
	}
}
