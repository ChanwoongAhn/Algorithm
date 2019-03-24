import java.util.*;

public class Pro11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String num = sc.next();
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			String temp = num.substring(i, i+1);
			sum += Integer.parseInt(temp);
		}
		System.out.println(sum);
	}
}
