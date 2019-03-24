import java.util.*;

public class SearchAlphabet {
	public static Scanner sc = new Scanner(System.in);
	public static int [] array = new int[26];
	public static int i = 0;
	
	public static void Alphaposition(String s) {
		for(int k = 0; k < array.length; k++)
			array[k] = -1;
		
		for(int j = 0; j < s.length(); j++) {
			char temp = s.charAt(i);
			if(array[temp-97] == -1)
				array[temp-97] = i;
			i++;
		}
		for(int j = 0; j < array.length; j++)
			System.out.print(array[j] + " ");
	}
	public static void main(String[] args) {
		String word = sc.next();
		Alphaposition(word);
	}
}
