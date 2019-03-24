import java.util.*;

public class Prob_4366 {
	public static Scanner sc = new Scanner(System.in);
	public static int bintodec(String s) {
		int result = 0;
		
		for(int i = 0; i < s.length() - 1; i++) 
			result += (int)(s.charAt(i) - 48)*Math.pow(2,s.length()-1-i);
		result += (s.charAt(s.length() - 1) - 48);
		return result;
	}
	public static int tertodec(String s) {
		int result = 0;
		
		for(int i = 0; i < s.length() - 1; i ++) 
			result += (int)(s.charAt(i) - 48)*Math.pow(3,  s.length()-1-i);
		result += (s.charAt(s.length() - 1) - 48);
		return result;
	}
	public static int getresult(String bin_num, String ter_num) {
		for(int i = 1; i < bin_num.length(); i++) {
			String tmp_bin = bin_num;
			String tmp_ter = ter_num;
			
			if(i == bin_num.length() - 1)
				bin_num = bin_num.substring(0,i) + (bin_num.charAt(i) + 1) % 2;
			else
				bin_num = bin_num.substring(0, i) + (bin_num.charAt(i) + 1) % 2 + bin_num.substring(i+1);
			for(int k = 0; k < ter_num.length(); k++) {
				if(k==0) {
					if(ter_num.charAt(k) == '1')
						ter_num = ter_num.substring(0,k) + "2" + ter_num.substring(k+1);
					else
						ter_num = ter_num.substring(0,k) + "1" + ter_num.substring(k+1);
					if (bintodec(bin_num) == tertodec(ter_num)) {
						return(bintodec(bin_num));
					}
				}
				else
					for(int j = 1; j < 3; j++) {
						if(k == ter_num.length() - 1)
							ter_num = ter_num.substring(0,k) + (ter_num.charAt(k) + j) % 3;
						else
							ter_num = ter_num.substring(0, k) + (ter_num.charAt(k) + j) % 3 + ter_num.substring(k+1);
						if (bintodec(bin_num) == tertodec(ter_num)) {
							return bintodec(bin_num);
						}
						else
							ter_num = tmp_ter;
					}
				ter_num = tmp_ter;
			}
			bin_num = tmp_bin;
		}
		return 0;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			String bin_num = sc.next();
			String ter_num = sc.next();
			
			System.out.print("#" + (order_label++) + " ");
			System.out.println(getresult(bin_num, ter_num));
		}
	}
}
