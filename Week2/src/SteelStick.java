// 마지막에 긴 쇠막대기가 두개로 나뉘어져있는 이유?
// 하나로 합칠 수 있지 않나?
import java.util.*;
import java.util.Stack;

public class SteelStick {
	public static Stack <Character> stack = new Stack();
	public static Scanner sc = new Scanner(System.in);
	public static int position = 0;
	
	public static boolean isRazer(String s, int p) {
		char tmp = s.charAt(p);
		if(tmp == '(' && s.charAt(p+1) == ')')
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String arrangement = sc.next();
		int i = 0;
		int razernum = 0;
		int divnum = 0;
		
		while(position < arrangement.length() - 1) {
			if(isRazer(arrangement, i)) {
				System.out.println("Razer!!");
				if(stack.isEmpty() == true) {
					i += 2;
					position += 2;
				}
				else {
					razernum ++;
					i += 2;
				}
			}
			else if((arrangement.charAt(i) == '(')) {
				System.out.println("push");
				stack.push('(');
				i ++;
			}
			else if((arrangement.charAt(i) == ')')) {
				System.out.println("pop");
				stack.pop();
				i++;
				if(stack.isEmpty() == true) {
					System.out.println("Finish");
					divnum += razernum + 1;
					razernum = 0;
					if(position < arrangement.length())
						position ++;
					
					if(position == arrangement.length()-1)
						break;
					
					while(arrangement.charAt(position) == ')' || isRazer(arrangement, position)) {
						if(position < arrangement.length())
							position ++;
						if(position == arrangement.length() - 1 )
							break;
					}
					i = position;
				}
			}
		}
		System.out.println(divnum);
	}
}
