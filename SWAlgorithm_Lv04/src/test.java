import java.util.*;

public class test {
	public static Scanner sc = new Scanner(System.in);
	public static boolean checkdate(int n, int d) {
		boolean result = false;
		switch(n) {
			case 1 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 2 :
				if(d >= 1 && d <= 28)
					result = true;
				break;
			case 3 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 4 : 
				if(d >= 1 && d <= 30)
					result = true;
				break;
			case 5 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 6 :
				if(d >= 1 && d <= 30)
					result = true;
			case 7 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 8 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 9 :
				if(d >= 1 && d <= 30)
					result = true;
				break;
			case 10 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
			case 11 :
				if(d >= 1 && d <= 30)
					result = true;
				break;
			case 12 :
				if(d >= 1 && d <= 31)
					result = true;
				break;
		}
		return result;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			String date = sc.next();
			int month = Integer.parseInt(date.substring(4,6));
			int day = Integer.parseInt(date.substring(6,8));
			
			if(!(month > 0 && month <= 12))
				System.out.println("#" +(order_label ++) + " " + "-1");
			else {
				if(checkdate(month, day))
					System.out.println("#" + (order_label++) + " " +date.substring(0,4) + "/" + date.substring(4,6) + "/" + date.substring(6,8));
				else
					System.out.println("#" +(order_label ++) + " " + "-1");			}
		}
	}

}
