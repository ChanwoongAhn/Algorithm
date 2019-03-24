/* 소수
 * 소수는 2부터 자기 자신의 값 까지 모두 나누어 볼 필요 없이, 루트 n까지만 나누어서 떨어지면 소수가 아니다. 
 * 이 논리를 이용하면 시간복잡도를 크게 줄일 수 있다.(수학자들에 의해 증명된 공식임)
 */

import java.util.*;

public class SearchPrimeNum {
	public static Scanner sc = new Scanner(System.in);
	
	public static void PrimeNum(int n) {
		int [] arr = new int[n];
		int numofprime = 0;
		
		while(n -- > 0) {
			arr[n] = sc.nextInt();
			if(arr[n] > 1000)
				break;
		}
		n = arr.length;
		while(n -- > 0) {
			boolean flag = true;
			if(arr[n] == 1)
				flag = false;
			for(int i = 2; i <= Math.sqrt(arr[n]); i++) {
				if(arr[n] % i == 0)
					flag = false;
			}	
			if(flag == true)
				numofprime ++;
		}
		System.out.println(numofprime);
	}
	public static void main(String[] args) {
		int n = sc.nextInt();
		if(n <= 100)
			PrimeNum(n);
	}
}
