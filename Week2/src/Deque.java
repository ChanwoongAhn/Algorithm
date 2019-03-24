import java.util.*;

public class Deque {
	public static Scanner sc = new Scanner(System.in);
	public static int position = 0;
	public static int [] arr = new int[10000];
	
	public static void push_front(int x) {
		for(int i = position; i > 0; i--) {
			arr[position] = arr[position-1];
		}
		arr[0] = x;
		position ++;
	}
	public static void push_back(int x) {
		arr[position] = x;
		position ++;
	}
	public static void pop_front() {
		if(position == 0)
			System.out.println("-1");
		else {
			System.out.println(arr[0]);
			for(int i = 0; i < position - 1; i++) {
				arr[i] = arr[i+1];
			}
			position --;
		}
	}
	public static void pop_back() {
		if(position == 0)
			System.out.println("-1");
		else {
			System.out.println(arr[position-1]);
			position --;
		}
	}
	public static void size() {
		if(position > 0)
			System.out.println(position);
		else
			System.out.println("0");
	}
	public static void empty() {
		if(position == 0)
			System.out.println("1");
		else
			System.out.println("0");
	}
	public static void front() {
		if(position == 0)
			System.out.println("-1");
		else
			System.out.println(arr[0]);
	}
	public static void back() {
		if(position == 0)
			System.out.println("-1");
		else
			System.out.println(arr[position-1]);
	}
	public static void main(String[] args) {
		int order = sc.nextInt();
		while(order > 0) {
			String command = sc.next();
			if(command.equals("push_front")) {
				int x = sc.nextInt();
				push_front(x);
			}
			else if(command.equals("push_back")) {
				int x = sc.nextInt();
				push_back(x);
			}
			else if(command.equals("pop_front"))
				pop_front();
			else if(command.equals("pop_back"))
				pop_back();
			else if(command.equals("size"))
				size();
			else if(command.equals("empty"))
				empty();
			else if(command.equals("front"))
				front();
			else if(command.equals("back"))
				back();
			order --;
		}
	}
}
