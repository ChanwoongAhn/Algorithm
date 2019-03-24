import java.util.*;
public class Prob_1874 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int [] arr;
	public static int point = 0;
	//수열을 만들 수 있는지 확인하는 함수
	public static boolean check_numerical() {
		int tmp = 0;
		boolean flag = true;
		for(int i = 0; i < n; i ++) {
			if(arr[i] == n) {
				tmp = i;
			}
		}
		for(int i = tmp + 1; i < n - 1; i ++) {
			if(arr[i + 1] >= arr[i])
				flag = false;
		}
		return flag;
	}
	
	public static void operater(int k) {
		if(k <= point) {
			for(int i = k; i < point; i ++)
				System.out.println("-");
		}
		else if(k > point) {
			for(int i = point; i < k; i ++) {
				System.out.println("+");
				point ++;
			}
			System.out.println("-");
		}
	}
	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = sc.nextInt();
	
		if(check_numerical()) {
			for(int i = 0; i < n; i ++) {
				if(i == 0) {
					point = arr[0];
					for(int j = 0; j < point; j ++)
						System.out.println("+");
					System.out.println("-");
				}
				else {
					if(point == n)
						System.out.println("-");
					else
						operater(arr[i]);
				}
			}
		}
		else {
			System.out.println("No");
		}
	}
}
