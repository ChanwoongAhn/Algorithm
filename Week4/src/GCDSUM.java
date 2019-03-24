import java.util.*;

public class GCDSUM {
	public static Scanner sc = new Scanner(System.in);
	
	public static int GCD(int x, int y) {
		int remainder = 1;
		int temp = 0;
		
		if(x < y) {
			temp = x;
			x = y;
			y = temp;
		}
		
		while(remainder > 0) {
			remainder = x%y;
			x = y;
			y = remainder;
		}
		return x;
	}
	public static void main(String[] args) {
		int order = sc.nextInt();
		int [] result = new int[order];
		int h = 0;
		
		while(order -- > 0) {
			int num = sc.nextInt();
			int [] arr = new int[num];
			int sum = 0;
			
			for(int i = 0; i < num; i++)
				arr[i] = sc.nextInt();
			
			for(int j = 0; j < num; j ++)
				for(int k = 0; k < num; k ++) {
					if(j == k || k < j) {
					}
					else
						sum += GCD(arr[j], arr[k]);
				}		
			result[h++] = sum;
		}
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
