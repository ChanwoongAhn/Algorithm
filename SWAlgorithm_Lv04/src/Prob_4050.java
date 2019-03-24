import java.util.*;
import java.util.Arrays;

public class Prob_4050 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase-- > 0) {
			int cloth_num = sc.nextInt();
			int [] price = new int[cloth_num];
			int total_price = 0;
			int cloth_pack = cloth_num / 3;
			
			for(int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
				total_price += price[i];
			}
			Arrays.sort(price);
			
			for(int i = price.length % 3; i < price.length; i += 3) {
				total_price -= price[i];
			}
			System.out.print("#" + (order_label ++) + " ");
			System.out.println(total_price);
		}
	}
}
