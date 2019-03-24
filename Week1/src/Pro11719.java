import java.util.*;

public class Pro11719 {

	static boolean checkSpecial(String s) {
		boolean flag = true;
		
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if((temp != 32 && temp != 9 && temp < 48) || (temp >= 58 && temp < 65) || (temp >= 91 && temp < 97) || (temp >= 123 && temp <= 127)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		String result = "";
		String temp = "";
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			temp = sc.nextLine();
			
			//줄에 알파벳, 공백, 숫자 이외의 문자가 있는 경우
			if(!checkSpecial(temp))
				break;
			//줄에 문자의 길이가 100글자를 넘는 경우
			if(temp.length() > 100)
				break;
			
			result += temp + "\n";
		}
		System.out.println(result);
	}
}
