import java.util.*;

public class Prob_6781 {
	public static Scanner sc = new Scanner(System.in);
	public static String card;
	public static String color;
	
	public static boolean verify() {
		boolean result = false;
		
		for(int i = 0; i < 7; i ++) {
			if((card.charAt(i) == card.charAt(i+1) - 1) && color.charAt(i) == color.charAt(i+1))
				if((card.charAt(i+1) == card.charAt(i+2) - 1) && color.charAt(i+1) == color.charAt(i+2)) {
					System.out.println("i : " +i);
					result = true;
					break;
				}		
		}
		return result;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			card = "";
			color = "";
			card = sc.next();
			color = sc.next();
			if(verify())
				System.out.println("#" + (order_label ++) + " " + "Win");
			else
				System.out.println("#" + (order_label ++) + " " + "Continue");
			
		}
	}
}
