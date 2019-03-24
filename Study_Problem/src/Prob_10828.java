import java.util.*;

public class Prob_10828 {
	public static int n;
	public static int [] arr;
	public static Scanner sc = new Scanner(System.in);
	public static int point = 0;
	
	public static void push(int x) {
		arr[point++] = x;
	}
	public static int pop() {
		if(arr[0] != 0) {
			int tmp = arr[point - 1];
			arr[point - 1] = 0;
			point --;
			return tmp;
		}
		else
			return -1;
	}
	public static int size() {
		return point;
	}
	public static void empty() {
		if(arr[0] == 0)
			System.out.println("1");
		else
			System.out.println("0");
	}
	public static void top() {
		if(arr[0] != 0)
			System.out.println(arr[point - 1]);
		else
			System.out.println("-1");
	}
	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i ++) {
			String order = sc.next();
			
			if(order.equals("push")) {
				int temp = sc.nextInt();
				push(temp);
			}
			else if(order.equals("pop")) {
				System.out.println(pop());
			}
			else if(order.equals("size")) {
				System.out.println(size());
			}
			else if(order.equals("empty")) {
				empty();
			}
			else if(order.equals("top")) {
				top();
			}
		}
	}
}
