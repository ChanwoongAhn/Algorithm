import java.util.*;
public class Prob_8958 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		
		while(testcase -- > 0) {
			String tmp = sc.next();
			int result = 0;
			int continuous = 0;
			for(int i = 0; i < tmp.length(); i ++) {
				if(tmp.charAt(i) == 'O') {
					continuous ++;
					result += continuous;
				}
				else {
					continuous = 0;
				}
			}
			System.out.println(result);
		}
	}
}
