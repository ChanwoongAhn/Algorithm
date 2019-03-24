import java.util.*;

public class Pro11721 {
	static boolean checkSpecial(String s) {
		boolean flag = true;
		
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if(!((temp >= 65 && temp < 91) || (temp >= 97 && temp < 123))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp = "";
		String result = "";
		
		
		temp = sc.nextLine();
		
		if(!checkSpecial(temp)) {
			System.out.println("Wrong Input! Try Again!");
			temp = sc.nextLine();
		}
		if(temp.length() > 100) {
			System.out.println("Index out of range! Try Again!");
			temp = sc.nextLine();
		}
		
		for(int i = 0; i < temp.length(); i+=10) {
			if((i+10) > temp.length())
				result += temp.substring(i, temp.length());
			else
				result += temp.substring(i, i+10) + "\n";
		}
		System.out.println(result);
	}
}
