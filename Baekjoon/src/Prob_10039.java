import java.util.*;

public class Prob_10039 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int [] score = new int[5];
		int avg = 0;
		
		for(int i = 0; i < 5; i ++) {
			score[i] = sc.nextInt();
			
			if(score[i] < 40)
				score[i] = 40;
			avg += score[i];
		}
		System.out.println(avg/5);
	}
}
