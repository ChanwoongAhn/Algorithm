import java.util.*;
import java.util.Queue;
import java.awt.Point;

public class Prob_16234_List {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static boolean [][] visited;
	public static int [][] map;
	public static int [] dx = {-1, 0, 1, 0};
	public static int [] dy = {0, 1, 0, -1};
	public static int r;
	public static int l;
	public static int k = 10;
	
	public static boolean check() {
		List<Node> n_list;
		
		boolean flag = true;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j ++) {
				if(!visited[i][j]) {
					n_list = new LinkedList<Node>();
					n_list.add(new Node(i, j));
					
					int sum = dfs(i, j, n_list, 0);
					if(n_list.size() > 1) {
						flag = false;
						change(sum, n_list);
					}
				}
			}
		}
		
		return flag;
	}
	
	public static int dfs(int x, int y, List<Node> n_list, int sum) {
		visited[x][y] = true;
		sum = map[x][y];
		
		for(int i = 0; i < 4; i ++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			
			if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= n)
				continue;
			if(!visited[next_x][next_y]) {
				int d = Math.abs(map[next_x][next_y] - map[x][y]);
				if(d >= l && d <= r) {
					n_list.add(new Node(next_x, next_y));
					sum += dfs(next_x, next_y, n_list, sum);
				}
			}
		}
		
		return sum;
	}
	
	public static void change(int sum, List<Node> n_list) {
		int value = sum / n_list.size();
		
		for(Node node : n_list) {
			map[node.x][node.y] = value;
		}
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		int result = 0;
		map = new int[n][n];
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++) 
				map[i][j] = sc.nextInt();
		
		while(true) {
			visited = new boolean[n][n];
			
			if(!check()) {
				result ++;
			}
			else
				break;
		}
		
		System.out.println(result);
	}

}
class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
