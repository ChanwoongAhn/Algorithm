import java.util.*;
import java.util.Stack;

public class Prob_2504 {
	public static Scanner sc = new Scanner(System.in);
	public static Stack<Character> stack = new Stack<>();
	
	public static boolean check_input(String s) {
		boolean result = true;
		char current_par = '(';
		
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
				current_par = s.charAt(i);
			}
			else {
				if(s.charAt(i) == ')') {
					if(stack.isEmpty()) {
						result = false;
						break;
					}
					else {
						if(stack.peek() == '(')
							stack.pop();
						else {
							result = false;
							break;
						}
					}
				}
				else if(s.charAt(i) == ']'){
					if(stack.isEmpty()) {
						result = false;
						break;
					}
					else {
						if(stack.peek() == '[')
							stack.pop();
						else {
							result = false;
							break;
						}
					}
				}
			}
		}
		if(!stack.isEmpty())
			result = false;
	
		return result;
	}
	public static int operation(String s) {
		int result = 0;
		int num = 1;
		
		for(int i = 0; i < s.length(); i ++) {
			char pos = s.charAt(i);
			switch(pos) {
				case '(' :
					stack.push(pos);
					num *= 2;
					if(i < s.length() - 1)
						if(s.charAt(i+1) == ')')
							result += num;
					break;
				case '[' :
					stack.push(pos);
					num *= 3;
					if(i < s.length() - 1)
						if(s.charAt(i+1) == ']')
							result += num;
					break;
				case ')' :
					stack.pop();
					num /= 2;
					break;
				case ']' :
					stack.pop();
					num /= 3;
					break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String text = sc.next();
		
		if(check_input(text))
			System.out.println(operation(text));
		else
			System.out.println("0");
		
		while(!stack.isEmpty())
			stack.pop();
	}

}
