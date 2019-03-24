import java.util.*;
import java.util.Arrays;

public class Prob_4111 {
	public static Scanner sc = new Scanner(System.in);
	public static int [] position;
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int camera_num = sc.nextInt();
			int receiver_num = sc.nextInt();
			int result = 0;
			position = new int[camera_num];
			int [] dist_arr = new int[camera_num - 1];
			
			for(int i = 0; i < camera_num; i++) {
				position[i] = sc.nextInt();
			}
			Arrays.sort(position);
			
			for(int i = 0; i < camera_num - 1; i++) {
				dist_arr[i] = position[i+1] - position[i];
			}
			Arrays.sort(dist_arr);

			if(camera_num <= receiver_num)
				result = 0;
			else
				for(int i = 0; i < dist_arr.length - receiver_num + 1; i++) {
					result += dist_arr[i];
				}
			System.out.print("#" + (order_label++) + " ");
			System.out.println(result);
		}
	}
}
