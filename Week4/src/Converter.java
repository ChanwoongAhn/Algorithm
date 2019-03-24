import java.util.*;

public class Converter {
	public static Scanner sc = new Scanner(System.in);
	
	public static void convert(String c, int x) {
		int result = 0;
		int i = 0;
		int position = c.length() - 1;
		
		while(position >= 0) {
			int tmp = 0;
			if(c.charAt(position) >= 65 && c.charAt(position) <=90)
				tmp = c.charAt(position) - 55;
			else
				tmp = c.charAt(position) - 48;
			
			if(i == 0) {
				result += tmp * 1;
			}
			else {
				int k = i;
				int sum = tmp;
				
				while(i-- > 0)
					sum *= x;
				result += sum;
				i = k;
			}
			i ++;
			position --;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		String c = sc.next();
		int x = sc.nextInt();
		
		convert(c, x);
	}
}
