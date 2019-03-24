import java.util.*;

public class Prob_3809 {
	public static Scanner sc = new Scanner(System.in);
	
	public static int min_integer() {
		int testnum = sc.nextInt();
		int [] arr = new int[testnum];
		int min_num = 0;
		int op_num = 0;
		
		for(int i = 1; i <= testnum; i++)
			op_num += i;
		
		for(int i = 0; i < testnum; i++)
			arr[i] = sc.nextInt();
	
		for(int j = 0; j < testnum; j++)
			for(int i = 0; i < testnum; i++) { // 1의자리 수에대한 탐색
				if(arr[i] == (min_num))
					min_num ++;
			}
		
		if(min_num == 10) {		// 두자리 수에 대한 탐색
			for(int i = 0; i < testnum - 1; i++)
				for(int j = 0; j < testnum - 1; j++) {
					String tmp = "" + arr[j] + arr[j+1];
					int num = Integer.parseInt(tmp);
					
					if(num == (min_num))
						min_num ++;
				}
		}
		
		if(min_num == 100) {
			for(int i = 0; i < testnum - 2; i++)
				for(int j = 0; j < testnum - 2; j++) {
					String tmp = "" + arr[j] + arr[j+1] + arr[j+2];
					int num = Integer.parseInt(tmp);
					
					if(num == (min_num))
						min_num ++;
				}
		}
		if(min_num == 1000) {
			for(int i = 0; i < testnum - 3; i++)
				for(int j = 0; j < testnum - 3; j++) {
					String tmp = "" + arr[j] + arr[j+1] + arr[j+2] + arr[j+3];
					int num = Integer.parseInt(tmp);
					
					if(num == (min_num))
						min_num ++;
				}
		}
		return min_num;

	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		int order = 1;
		
		while(testcase_num -- > 0) {
			System.out.println("#" + (order++) + " " +min_integer());
		}
	}

}
