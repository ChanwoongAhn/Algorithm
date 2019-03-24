import java.util.*;
public class Prob_1966 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int [] arr;
	public static int [] order_arr;
	public static int [] temp_arr;
	public static void check_order() {
		for(int i = 0; i < n; i ++) {
			int k = 0;
			int origin = arr[i];
			for(int j = i; j < n; j ++) {
				if(arr[j] > origin) {
					origin = arr[j];
					k = j;
				}
			}
			//¿ø¼Ò °ª ¹Ù²Þ
			int point = k;
			for(int x = 0; x < k; x ++) {
				temp_arr[x] = arr[point++];
			}
			int a = 0;
			for(int x = k; x < n; x ++) {
				temp_arr[x] = arr[a++];
			}
			for(int x = 0; x < n; x ++) {
				arr[x] = temp_arr[x];
			}
			
			//ÀÚ¸® °ª ¹Ù²Þ
			point = k;
			a = 0;
			
			for(int x = 0; x < k; x ++) {
				temp_arr[x] = arr[point++];
			}
			for(int x = k; x < n; x ++) {
				temp_arr[x] = arr[a++];
			}
			for(int x = 0; x < n; x ++) {
				order_arr[x] = temp_arr[x];
			}
		}
		
		for(int i = 0; i < n; i ++)
			if(order_arr[i] == 1) {
				System.out.println(i);
				break;
			}
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i ++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			arr = new int[n];
			order_arr = new int[n];
			temp_arr = new int[n];
			
			order_arr[m] = 1;
			check_order();
		}
	}

}
