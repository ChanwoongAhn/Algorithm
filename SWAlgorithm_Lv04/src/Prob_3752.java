import java.util.*;
import java.util.HashSet;

public class Prob_3752 {
	public static Scanner sc = new Scanner(System.in);
	
	public static int caseofresult(int num) {
		HashSet<Integer> resultvalue = new HashSet<>();
		
		resultvalue.add(0);
		for(int i = 0; i < num; i ++) {
			int tmp = sc.nextInt();
			HashSet<Integer> element = new HashSet<>();
			
			for(int item : resultvalue)
				element.add(tmp + item);
			resultvalue.addAll(element);
		}
		return resultvalue.size();
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int num = sc.nextInt();
			
			System.out.print("#" + (order_label ++) + " ");
			System.out.println(caseofresult(num));
		}
	}
}
