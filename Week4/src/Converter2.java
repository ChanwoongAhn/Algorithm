import java.util.*;

public class Converter2 {
	public static Scanner sc = new Scanner(System.in);
	public static int [] arr = new int [1000];
	
	public static void convert(int n, int x) {
		int remainder = x+1;
		int i = 0;
		while(n >= x) {
			remainder = n % x;
			n = n / x;
			arr[i++] = remainder;
		}
		arr[i] = n;
		
		for(; i >= 0; i--) {
			if(arr[i] >= 10 && arr[i] <= 35) {
				System.out.print((char)(arr[i]+55));
			}
			else
				System.out.print(arr[i]);
		}
	}
	public static void main(String[] args) {
		int num = sc.nextInt();
		int x = sc.nextInt();
	
		convert(num, x);
	}
}
