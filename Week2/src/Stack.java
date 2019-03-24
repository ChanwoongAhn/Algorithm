/*
자바에서 문자열 비교시, 문자열이 저장된 변수와 문자열 비교(command == "push")와 같은 경우
리터럴 문자와의 비교를 하는 것이 아니라, 저장된 주소값을 비교한다.
따라서 리터럴로 선언된 값은 변수가 달라도 같은 문자열이 있다면 동일한 주소값을 가리키고 있다.
위와 같은 비교는 equals라는 메소드를 사용, command.equals("push")로 문자열 비교를 한다.
위와 같이 비교를 하게 되면 같은 문자열을 가지고 있더라도 주소 값이 다르므로, 항상 거짓이 나옴.
 */

import java.util.*;

public class Stack {
	public static Scanner sc = new Scanner(System.in);
	public static int order = 0;
	public static int [] arr = new int[100];
	
	public static void push() {
		int x = sc.nextInt();
		
		arr[order++] = x;
	}
	public static void pop() {
		if (order == 0)
			System.out.println("-1");
		else {
			System.out.println(arr[order-1]);
			order --;
		}
	}
	public static void size() {
		System.out.println(order);
	}
	public static void empty() {
		if(order == 0)
			System.out.println("1");
		else
			System.out.println("0");
	}
	public static void top() {
		if (order == 0)
			System.out.println("-1");
		else
			System.out.println(arr[order - 1]);
	}
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		while(n > 0) {
			String command = sc.next();

			if(command.equals("push"))
				push();
			else if(command.equals("pop"))
				pop();
			else if(command.equals("size"))
				size();
			else if(command.equals("empty"))
				empty();
			else if(command.equals("top"))
				top();
			else
				System.out.println("error");
			n--;
			
		}
	}
}
