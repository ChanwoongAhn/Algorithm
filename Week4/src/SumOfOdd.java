import java.util.*;

public class SumOfOdd {
	public static Scanner sc = new Scanner(System.in);
	
	public static int searchmaxnum() {
		int maxnum = 0;
		int tmp;
		
		for(int i = 0; i < 10; i++) {
			tmp = sc.nextInt();
			if(tmp > maxnum)
				maxnum = tmp;
		}
		return maxnum;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int [] arr = new int[testcase];
		
		for(int i = 0; i < testcase; i++) {
			arr[i] = searchmaxnum();
		}
		
		for(int i = 0; i < testcase; i++) {
			System.out.println("#" + (i+1) + " " +arr[i]);
		}
	}
}
