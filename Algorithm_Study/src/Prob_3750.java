import java.util.*;

public class Prob_3750 {
	public static Scanner sc = new Scanner(System.in);
	
	public static String digitsum(String n) {
		String num = "" + n;
		int sum = 0;
		
		while(num.length() != 1) {
			for(int i = 0; i < num.length(); i++) {
				if(i == num.length() - 1)
					sum += Integer.parseInt(num.substring(i));
				else
					sum += Integer.parseInt(num.substring(i, i+1));
			}
			num = "" + sum;
			sum = 0;
		}
		
		return num;
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int num_label = 1;
		
		while(testcase_num -- > 0) {
			String n = sc.next();
			
			System.out.println("#" + (num_label++) +" " +digitsum(n));
		}
	}
}
