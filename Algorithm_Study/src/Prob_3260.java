// 1. 배열에 각 자릿수 값을 넣어준다
// 2. string 타입으로 숫자를 일정 간격으로 잘라서 더해준 뒤 합친다

import java.util.*;

public class Prob_3260 {
	public static int [] arr_a;
	public static int [] arr_b;
	public static int [] arr_result;
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void result(String a, String b) {
		int n;
		int k = 0;
		
		if(a.length() < b.length()) {
			n = b.length();
			String tmp;
			tmp = a;
			a = b;
			b = tmp;
		}
		else 
			n = a.length();

		arr_a = new int[n];
		arr_b = new int[n];
		arr_result = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr_a[i] = a.charAt(i) - 48;
			if(i < Math.abs(a.length() - b.length()))
				arr_b[k] = 0;
			else
				arr_b[k] = b.charAt(i) - 48;
			arr_result[i] = arr_a[i] + arr_b[k++];
			if(arr_result[i] >= 10) {
				if(i > 0) {
					arr_result[i-1]++;
					arr_result[i] -= 10;	
					System.out.print(arr_result[i]);
				}
				else
					System.out.print("1" + (arr_result[i]-10));
			}
			else
				System.out.print(arr_result[i]);
		}
		
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			String a = sc.next();
			String b = sc.next();
			
			System.out.print("#" + (order_label++) + " ");
			result(a,b);
			System.out.println();
		}
	}
}

