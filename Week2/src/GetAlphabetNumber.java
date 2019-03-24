import java.util.*;

public class GetAlphabetNumber {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String word = sc.next();
		int [] arr = new int[26];
		
		for(int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			int k = temp - 97;
			arr[k] += 1;
		}
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
