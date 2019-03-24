import java.util.*;
import java.util.Stack;

public class Parenthesis {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		int num = sc.nextInt();
		
		while(num-- > 0) {
			String result = "YES";
			String line = sc.next();

			if(line.length() >= 2 && line.length() <= 50) {
				for(int i = 0; i < line.length(); i++) {
					char tmp = line.charAt(i);
					
					if(tmp == '(') {
						stack.push(tmp);
					}
					else if (tmp == ')') {
						if(!stack.isEmpty())
							stack.pop();
						else {
							result = "NO";
							break;
						}
					}
					else
						break;
				}
				if(!stack.isEmpty())
					result = "NO";
				System.out.println(result);
				while(stack.size() != 0)
					stack.pop();
			}
		}
	}
}
	/*
	stack.push(1);
	stack.push(2);
	
	System.out.println(stack.peek());
	System.out.println(stack.size());
	System.out.println("---------");
	System.out.println(stack.pop());
	System.out.println(stack.size());
	System.out.println("---------");
	System.out.println(stack.isEmpty());
	System.out.println(stack.pop());
	System.out.println(stack.isEmpty());
	*/
