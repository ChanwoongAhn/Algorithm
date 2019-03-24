import java.util.*;

public class Josepause {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [] result_arr = new int[n];
		int [] arr = new int[n];
		int j = 0;
		int tmp = m;
		for(int i = 0; i < n; i ++)
			arr[i] = i+1;
		
		while (n > 0) {
			result_arr[j++] = arr[tmp-1];
			for(int i = tmp-1; i < n - 1; i++)
				arr[i] = arr[i+1];
			tmp =  tmp + m - 1;
			
			n--;
			while(tmp > n && n != 0) {
				tmp = tmp - n;
			}
		}
		System.out.print("<");
		for(int i = 0; i < result_arr.length - 1; i++)
			System.out.print(result_arr[i] + ", ");
		System.out.print(result_arr[arr.length-1] + ">");
	}
}
