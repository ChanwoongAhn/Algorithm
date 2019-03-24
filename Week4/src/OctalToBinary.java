import java.util.*;

public class OctalToBinary {
	public static Scanner sc = new Scanner(System.in);
	
	public static void Convert(String s) {
		String result = "";
		int i = 0;
		while(i <s.length()) {
			int tmp = s.charAt(i) - 48;
			int k = 0;
			String sum = "";
			while(k ++ < 3) {
				sum = tmp % 2 + sum;
				tmp = tmp / 2;
			}
			if(sum.length() == 2)
				sum = "0" + sum;
			else if(sum.length() == 1)
				sum = "00" + sum;
			result = result + sum;
			i++;
		}
		int t = 0;
		for(int j = 0; j < 3; j++) {
			if(result.charAt(j) == '1') {
				t = j;
				break;
			}
		}
		result = result.substring(t);
		System.out.println(result);
	}
	public static void main(String[] args) {
		String num = sc.next();
		Convert(num);
	}
}
