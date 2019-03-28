import java.util.Scanner;
public class Prob_2839 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int min_pack = 10000;
		int i = 0;
		
		while(5*i <= n) {
			int num = n;
			int result = 0;
			int remain = 0;
			
			num = num - 5*i;
			result = i + num/3;
			remain = num%3;
			if(result < min_pack && remain == 0)
				min_pack = result;
			i ++;
		}
		
		if(min_pack == 10000)
			System.out.println(-1);
		else
			System.out.println(min_pack);
	}
}
