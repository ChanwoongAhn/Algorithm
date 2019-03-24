import java.util.*;

public class Prob3812 {
	public static Scanner sc = new Scanner(System.in);
	public static int num = 1;
	public static void coloring() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		int [] arr = new int[n];
		int tmp = 0;
		
		for(int i = 0; i < x; i++) 
			for(int j = 0; j < y; j++) 
				for(int k = 0; k < z; k++) {
					tmp = (Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c)) % n;
					arr[tmp] ++;
				}
		System.out.print("#" + num + " ");
		num ++;
		
		for(int i = 0; i < n; i ++) {
			if(i == n-1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
			
		while(testcase -- > 0) {
			coloring();
		}
	}

}
