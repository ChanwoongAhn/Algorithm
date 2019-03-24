import java.util.*; 
import java.util.Arrays;

public class SuffixArray {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String s = sc.next();
		String [] array = new String[s.length()];
		for(int i = 0; i < s.length(); i++) {
			array[i] = s.substring(i);
		}
		Arrays.sort(array);
		for(int i = 0; i < s.length(); i++)
			System.out.println(array[i]);
	}
}
