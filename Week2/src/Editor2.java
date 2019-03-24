import java.util.*;

public class Editor2 {
	public static Scanner sc = new Scanner(System.in);
	public static int cursor = 0;
	
	public static void main(String[] args) {
		String sentence = sc.next();
		int order = sc.nextInt();
		
		cursor = sentence.length();
		System.out.println(cursor);

		while(order -- > 0) {
			String command = sc.next();
			
			if(command.equals("L")) {
				if(cursor != 0) {
					cursor --;
				}
			}
			else if(command.equals("D")) {
				if(cursor != sentence.length()) {
					cursor ++;
				}
			}
			else if(command.equals("B")) {
				if(cursor != 0) {
					sentence = sentence.substring(0, cursor - 1) + sentence.substring(cursor);
					cursor --;
				}
			}
			else if(command.equals("P")) {
				String temp = sc.next();
				sentence = sentence.substring(0, cursor) + temp + sentence.substring(cursor);
				cursor ++;
			}
		}
		System.out.println(sentence);
	}
}
