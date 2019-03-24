import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Prob_4411 {
	public static Scanner sc = new Scanner(System.in);
	public static long getresult(long n, long k) {
		Queue <Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++)
			queue.add(i);
		while(queue.size() > 1) {
			for(int i = 0; i < k; i ++) {
				int temp = queue.poll();
				queue.add(temp);
			}
			queue.poll();
		}		
		return queue.poll();
	}
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int test_label = 1;
		
		while(testcase -- > 0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			System.out.print("#" + (test_label++) + " ");
			System.out.println(getresult(n,k));
		}
	}
}
