import java.util.*;
import java.util.HashSet;
/*
public class Prob_3501 {
	public static Scanner sc = new Scanner(System.in);
	
	public static boolean isPrimefactor(int num) {
		while(num % 2 == 0) 
			num /= 2;
		while(num % 5 == 0)
			num /= 5;
		if (num != 1)
			return true;
		else
			return false;
	}
	public static String search_circulation(int n, int d) {
		String num = "" + ((double)n / (double)d);
		String circulation = "";
		int k = 4;
		int i = 4;
		HashSet <Integer> tmp = new HashSet<>();
		tmp.add((int)num.charAt(3) - 48);
		
		while(!tmp.isEmpty()) {
			int value = num.charAt(k++) - 48;
			if(tmp.contains(value))
				tmp.remove(value);
			else {
				tmp.add(value);
				circulation += value;
			}
			
			if(k == num.length()) {
				tmp.remove((int)num.charAt(i++) - 48);
				
			}
		}
		
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int numerater = sc.nextInt();
			int denominator = sc.nextInt();
			
			System.out.print("#" + (order_label ++) + " ");
			if(isPrimefactor(denominator)) {
				
				
			}
		}

	}

}
*/