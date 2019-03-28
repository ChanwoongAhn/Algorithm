import java.util.*;

public class Prob_1065 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int result = 99;
		String tmp;
		
		if(n < 100)
			System.out.println(n);
		else {
			for(int i = 100; i <= n; i ++) {
				tmp = "" + i;
				if((tmp.charAt(0) - 48) - (tmp.charAt(1) - 48) == (tmp.charAt(1) - 48) - (tmp.charAt(2) - 48))
					result ++;	
			}
			System.out.println(result);
		}
	}
}
