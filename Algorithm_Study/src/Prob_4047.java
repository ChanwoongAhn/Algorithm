import java.util.*;

public class Prob_4047 {
	public static Scanner sc = new Scanner(System.in);
	public static String [] arr = new String[52];
	
	public static void main(String[] args) {
		String info = "";
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			info = sc.next();
			int j = 0;
			String result = "";
			int [] result_arr = new int[4];
			
			for(int i = 0; i < info.length()/3; i++) {
				arr[i] = info.substring(j, j+3);
				j += 3;
			}
			
			for(int i = 0; i < info.length()/3; i++) {
				for(int k = i+1; k < info.length()/3; k++) {
					if(arr[i].equals(arr[k]))
						result = "ERROR";
				}
			}
			if(!result.equals("ERROR")) {
				for(int i = 0; i < info.length()/3; i++) {
					if(arr[i].charAt(0) == 'S')
						result_arr[0] ++;
					else if(arr[i].charAt(0) == 'D')
						result_arr[1] ++;
					else if(arr[i].charAt(0) == 'H')
						result_arr[2] ++;
					else if(arr[i].charAt(0) == 'C')
						result_arr[3] ++;
				}
				System.out.print("#" + (order_label++) + " ");
				
				for(int i = 0; i < 4; i++)
					if(i == 3)
						System.out.print(13 - result_arr[i]);
					else
						System.out.print(13 - result_arr[i] + " ");
				System.out.println();
			}
			else {
				System.out.print("#" + (order_label++) + " ");
				System.out.println(result);
			}
		}
	}
}
