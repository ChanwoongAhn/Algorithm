import java.util.*;
import java.util.Queue;

public class Prob_5550 {
	public static Queue<Character> queue = new LinkedList<Character>();
	public static Scanner sc = new Scanner(System.in);
	
	public static int getresult(String s) {
		int frog_num = 0;
		int j = 0;
		String frog = "croak";
		
		for(int i = 0; i < s.length(); i ++) {
			queue.add(s.charAt(i));
			
			if(frog.charAt(j) == s.charAt(i)) {
				queue.remove(frog.charAt(j));
				j ++;
				
				if(j == 5) {
					j -= 5;
					frog_num ++;
				}
			}
		}
		if(frog_num == 0)
			return -1;
		else
			return frog_num;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			String s = sc.next();
			
			System.out.println("#" + (order_label++) + " " +getresult(s));
			queue.clear();
		}

	}

}
