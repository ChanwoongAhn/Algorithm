import java.util.Scanner;

public class Prob_2577 {
public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int mult = a*b*c;
		String s = "" + mult;
		int [] result = new int[10];
		
		for(int i = 0; i < s.length(); i ++)
			result[s.charAt(i) - 48] ++;
		
		for(int i = 0; i < 10; i ++)
			System.out.println(result[i]);
	}
}
