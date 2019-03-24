import java.util.*;

public class SentenceAnalyzation {
	public static Scanner sc = new Scanner(System.in);
	public static int [] array = new int[4];
	
	public static void NumofEachType(String s) {
		for(int i = 0; i < array.length; i++)
			array[i] = 0;

		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(temp >= 97 && temp <= 122)
				array[0] ++;
			else if(temp >= 65 && temp <= 90)
				array[1] ++;
			else if(temp >= 48 && temp <= 57)
				array[2] ++;
			else if(temp == 32)
				array[3] ++;
		}
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		String words = new String();
		
		while(sc.hasNextLine()) {
			/*
			공백도 문자열에 포함되므로 nextLine()을 사용.
			next() 사용 시 공백을 기준으로 문자열이 끊어짐
			예를 들면, This is String 이라는 문자열은 This, is, String 으로 나뉘어 저장됨
			*/
			words = sc.nextLine();
			NumofEachType(words);
		}
	}

}
