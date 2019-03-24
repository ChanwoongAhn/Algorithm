import java.util.*;

public class Prob_3975 {
	public static Scanner sc = new Scanner(System.in);
	
	public static String winner(int a, int b, int c, int d) {
		double Alice_WR = (double)a / (double)b;
		double Bob_WR = (double)c / (double)d;
		
		if(Alice_WR > Bob_WR)
			return "ALICE";
		else if(Alice_WR < Bob_WR)
			return "BOB";
		else
			return "DRAW";
	}
	public static void main(String[] args) {
		int testcase_num = sc.nextInt();
		String [] arr = new String[testcase_num];
		
		while(testcase_num -- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			System.out.println(winner(a,b,c,d));
		}
	}
}
