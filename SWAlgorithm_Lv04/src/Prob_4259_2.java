import java.util.*;
import java.math.BigInteger;

public class Prob_4259_2 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int numofoperate = sc.nextInt();
			BigInteger sum = new BigInteger("0");
			
			long result = 0;
			String [] arr = new String[numofoperate];
			
			for(int i = 0; i < numofoperate; i++)
					arr[i] = sc.next();
			
			for(int i = 0; i < numofoperate; i++) {
				int num = Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
				int exp = Integer.parseInt(arr[i].substring(arr[i].length() - 1,  arr[i].length()));
				
				BigInteger tmp = BigInteger.valueOf(exp);
				tmp = tmp.pow(exp);
				sum = sum.add(tmp);
			}
			System.out.print("#" + (order_label++) + " ");
			System.out.println(sum);
		}
	}
}
