import java.util.*;

public class Queue {
	public static Scanner sc = new Scanner(System.in);
	public static int [] arr = new int[10000];
	public static int position = 0;

	public static void push(int x) {
		arr[position++] = x;
	}
	public static void pop() {
		if(arr[0] == 0)
			System.out.println("-1");
		else {
			System.out.println(arr[0]);
			arr[0] = 0;
			position --;
			for(int i = 0; i < position; i++) {
				arr[i] = arr[i+1];
			}
		}
	}
	public static void size() {
		System.out.println(position);
	}
	public static void empty() {
		if(arr[0] == 0)
			System.out.println("1");
		else
			System.out.println("0");
	}
	public static void front() {
		if(arr[0] == 0)
			System.out.println("-1");
		else 
			System.out.println(arr[0]);
	}
	public static void back() {
		if(arr[0] == 0)
			System.out.println("-1");
		else
			System.out.println(arr[position-1]);
	}
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		while(n-- > 0) {
			String command = sc.next();
			if(command.equals("push")) {
				int temp = sc.nextInt();
				push(temp);
			}
			else if(command.equals("pop"))
				pop();
			else if(command.equals("size"))
				size();
			else if(command.equals("empty"))
				empty();
			else if(command.equals("front"))
				front();
			else if(command.equals("back"))
				back();
		}
	}
}
