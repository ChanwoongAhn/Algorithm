import java.util.*;

public class Pro11718 {
	static boolean checkSpecial(String s) {
		boolean flag = true;
		
		for(int i = 0; i < s.length(); i++) {
			//s.charAt(i)는 s문자열의 i번째 값을 반환함. abcd에서 charAt(1) = b.
			char k = s.charAt(i);
			//알파벳, 공백, 숫자 이외의 값인 경우
			if((k < 48) || (k >= 58 && k <= 64) || (k >= 91 && k <=96) || (k >= 123 && k <= 126)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String result = "";
		String temp = "";
		while(sc.hasNextLine()) {
			temp = sc.nextLine();
			
			//알파벳, 공백, 숫자 이외의 값이 있는 경우
			if(!checkSpecial(temp)) 
				break;
			//한 줄이 100글자를 넘는 경우
			if(temp.length() > 100)
				break;
			//공백으로 시작할 경우
			if(temp.charAt(0) == 32)
				break;
			//공백으로 끝날 경우
			if(temp.charAt(temp.length()-1) == 32)
				break;
			
			result += temp + "\n";
		}
		System.out.println(result);
	}
}
