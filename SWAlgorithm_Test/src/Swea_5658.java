import java.util.*;

public class Swea_5658 {
	public static Scanner sc = new Scanner(System.in);
	
	public static long hexatodeci(String s) {
		long decimal = 0;
		int j = s.length() - 1;
		
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(j) >= 65)
				decimal += ((int)s.charAt(j--) - 55) * Math.pow(16, i);
			else
				decimal += ((int)s.charAt(j--) - 48) * Math.pow(16, i);
		}
		return decimal;
	}
	
	public static long getResult(long [] arr, int k) {
		for(int i = 0; i < arr.length; i ++) {
			for(int j = i+1; j < arr.length; j ++) {
				if(arr[i] < arr[j]) {
					long temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				else if(arr[i] == arr[j])
					arr[j] = 0;
			}
		}
		return arr[k-1];
	}
	
	public static String [] makegroup(String num, String [] arr) {
		int size = num.length() / 4;
		int pos = 0;
		num += num;
		
		for(int i = 0; i < num.length()/2; i ++) {
			arr[pos++] = num.substring(i, i+size);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String num = sc.next();
			long [] result = new long[num.length()];
			String [] grouped_num = new String[num.length()];
			
			makegroup(num, grouped_num);
			
			for(int i = 0; i < num.length(); i ++) 
				result[i] = hexatodeci(grouped_num[i]);
			
			System.out.println("#" + (order_label ++) + " " +getResult(result, k));
		}
	}
}
