import java.util.*;

public class ROT13 {
	public static Scanner sc = new Scanner(System.in);

	public static void Convert(String s) {
		char [] array = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if((temp >= 65 && temp <= 90)) {
				if(temp + 13 > 90)
					array[i] = (char)(temp-13);
				else
					array[i] = (char)(temp+13);
			}
			else if(temp >= 97 && temp <= 122) {
				if(temp + 13 > 122)
					array[i] = (char)(temp-13);
				else
					array[i] = (char)(temp+13);
			}
			else
				array[i] = temp;
		}
		for(int i = 0; i <array.length; i++)
			System.out.print(array[i]);
	}
	
	public static void main(String[] args) {
		String words = sc.nextLine();
		Convert(words);
	}
}
