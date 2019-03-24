import java.util.*;

public class BinaryToOctal {
	public static Scanner sc = new Scanner(System.in);
/*	
	public static int binaryToDecimal(String x) {
		int position = x.length() - 1;
		int result = 0;
		int i = 0;
		
		while(position >= 0) {
			int tmp = x.charAt(position) - 48;
			if(i == 0) {
				result += tmp;
			}
			else {
				int sum = tmp;
				int k = i;
				while(i -- > 0)
					sum *= 2;
				result += sum;
				i = k;
			}
			i++;
			position --;
		}
		return result;
	}
	public static String DecimalToOctal(int x) {
		String binary = "";
		int tmp = 0;
		
		while(x >= 8) {
			tmp = x % 8;
			binary = tmp + binary;
			x = x/8;
		}
		binary = x + binary;
		
		return binary;
	}
*/
	public static void binaryToOctal(String x) {
		if(x.length() % 3 == 1)
			x = "00" + x;
		else if(x.length() % 3 == 2)
			x = "0" + x;

		int size = x.length() / 3;
		String result = "";
		int i = 0;
		String tmp = "";
		while(size -- > 0) {
			int sum = 0;
			tmp = x.substring(3*i, 3*i+3);
			int k = 0;

			while(k < 3) {
				int t = tmp.charAt(k) - 48;
				if(k == 0)
					sum += t*2*2;
				else if(k == 1)
					sum += t*2;
				else
					sum += t;
				k++;
			}
			result = result + sum;
			i++;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		String num = sc.next();

		binaryToOctal(num);
		//System.out.println(DecimalToOctal(binaryToDecimal(num)));
	}
}
