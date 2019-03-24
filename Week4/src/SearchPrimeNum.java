/* �Ҽ�
 * �Ҽ��� 2���� �ڱ� �ڽ��� �� ���� ��� ������ �� �ʿ� ����, ��Ʈ n������ ����� �������� �Ҽ��� �ƴϴ�. 
 * �� ���� �̿��ϸ� �ð����⵵�� ũ�� ���� �� �ִ�.(�����ڵ鿡 ���� ����� ������)
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
