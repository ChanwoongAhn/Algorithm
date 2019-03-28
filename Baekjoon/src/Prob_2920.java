import java.util.*;
public class Prob_2920 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int [] n = new int[8];
		String result = "mixed";
		
		for(int i = 0; i < 8; i ++) 
			n[i] = sc.nextInt();
			
		for(int i = 0; i < 7; i ++) {
			if(n[i+1] - n[i] == 1) {
				if(i == 6)
					result = "ascending";
				else
					continue;
			}
			else
				break;			
		}
		for(int i = 0; i < 7; i ++) {
			if(n[i+1] - n[i] == -1) {
				if(i == 6)
					result = "descending";
				else
					continue;
			}
			else
				break;			
		}
		System.out.println(result);
	}
}
