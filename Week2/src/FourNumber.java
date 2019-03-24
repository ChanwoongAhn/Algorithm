import java.util.*;

public class FourNumber {
	public static Scanner sc = new Scanner(System.in);
	public static String [] array = new String[4];
	
	public static void main(String[] args) {
		String s = sc.nextLine();
		String num1 = "";
		String num2 = "";
		int k = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if(tmp != ' ') {
				if(array[k] != null)	//문자열 배열 초기화 시 null값이 들어 있기 때문
					array[k] += tmp;
				else
					array[k] = ""+tmp;
			}
			else
				k++;
		}
		num1 = array[0] + array[1];
		num2 = array[2] + array[3];
	
		while(num1.length() != num2.length()) {
			if(num1.length() < num2.length())
				num1 = "0"+num1;
			else
				num2 = "0"+num2;
		}

		int [] result = new int[num1.length()+1];
		for(int i = 0; i < result.length; i++)
			result[i] = 0;
		
		for(int j = num1.length() - 1; j >= 0; j--) {
			int tmp1 = num1.charAt(j) - 48;
			int tmp2 = num2.charAt(j) - 48;
			
			if(tmp1 + tmp2 + result[j+1] >= 10) {
				if(j != 0) {
					result[j+1] += tmp1 + tmp2 - 10;
					result[j] ++;
				}
				else {
					result[j+1] += tmp1 + tmp2 - 10;
					result[0] ++;
				}
			}
			else 
					result[j+1] += tmp1 + tmp2;	
		}
		if(result[0] != 0)
			System.out.print(result[0]);
		for(int j = 1; j < result.length; j++)
				System.out.print(result[j]);
	}
}
