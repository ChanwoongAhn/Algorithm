import java.util.*;
import java.math.BigInteger;

public class Prob_4259 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int numofoperate = sc.nextInt();
			long result = 0;
			String [] arr = new String[numofoperate];
			
			for(int i = 0; i < numofoperate; i++)
					arr[i] = sc.next();
			
			for(int i = 0; i < numofoperate; i++) {
				result += Math.pow(Double.parseDouble(arr[i].substring(0, arr[i].length() -1)), Double.parseDouble(arr[i].substring(arr[i].length()-1, arr[i].length())));
			}
			System.out.print("#" + (order_label++) + " ");
			System.out.println(result);
		}
	}
}
