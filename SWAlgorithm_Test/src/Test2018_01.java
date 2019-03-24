import java.util.*;
import java.util.Queue;
import java.awt.Point;
import java.util.ArrayList;

public class Test2018_01 {
	public static Scanner sc = new Scanner(System.in);
	public static Queue <Point> queue = new LinkedList<Point>();
	public static int [][] map;
	public static int n, m;
	public static int queue_size;
	public static int max_num = 99999;
	public static ArrayList<Node> list = new ArrayList<Node>();
	
	public static void detect(int [][] visited, int x, int y, int direction) {
		switch(direction) {
			case 0 :
				for(int i = y; i >= 0; i --) {
					if(visited[x][i] == 6)
						break;
					else {
						visited[x][i] = 7;
					}
				}
				break;
			case 1 :
				for(int i = x; i >= 0; i --) {
					if(visited[i][y] == 6)
						break;
					else {
						visited[i][y] = 7;
					}
				}
				break;
			case 2 :
				for(int i = y; i < m; i ++) {
					if(visited[x][i] == 6)
						break;
					else {
						visited[x][i] = 7;
					}
				}
				break;
			case 3 :
				for(int i = x; i < n; i ++) {
					if(visited[i][y] == 6)
						break;
					else {
						visited[i][y] = 7;
					}
				}
				break;
		}
	}
	public static void search(int cctvnum, int [][] prev) {
		int [][] visited = new int[n][m];
		
		if(cctvnum == queue_size) {
			int tmp = 0;
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < m; j ++) {
					if(prev[i][j] == 0)
						tmp ++;
				}
			if(tmp < max_num)
				max_num = tmp;
		}
		else {
			
			int x = queue.peek().x;
			int y = queue.poll().y;
			int num = map[x][y];
			/*
			Node node = list.get(cctvnum);
			int idx = node.index;
			int x = node.x;
			int y = node.y;
			*/
			switch(num) {
				case 1 :
					for(int i = 0; i < 4; i ++) {
						for(int k = 0; k < n; k ++) {
							visited[k] = Arrays.copyOf(prev[k], m);
						}
						
						detect(visited, x, y, i);
						search(cctvnum + 1, visited);
					}
					break;
				case 2 :
					for(int i = 0; i < 2; i ++) {
						for(int k = 0; k < n; k ++) {
							visited[k] = Arrays.copyOf(prev[k], m);
						}
						
						detect(visited, x, y, i);
						detect(visited, x, y, (i + 2)%4);
						search(cctvnum + 1, visited);
					}
					break;
				case 3 :
					for(int i = 0; i < 4; i ++) {
						for(int k = 0; k < n; k ++) {
							visited[k] = Arrays.copyOf(prev[k], m);
						}
						
						detect(visited, x, y, i);
						detect(visited, x, y, (i+1)%4);
						search(cctvnum + 1, visited);
					}
					break;
				case 4 :
					for(int i = 0; i < 4; i ++) {
						for(int k = 0; k < n; k ++)
							visited[k] = Arrays.copyOf(prev[k], m);
						
						detect(visited, x, y, i);
						detect(visited, x, y, (i+1)%4);
						detect(visited, x, y, (i+2)%4);
						search(cctvnum + 1, visited);
					}
					break;
				case 5 :
					for(int k = 0; k < n; k ++) {
						visited[k] = Arrays.copyOf(prev[k], m);
					}
					
					detect(visited, x, y, 0);
					detect(visited, x, y, 1);
					detect(visited, x, y, 2);
					detect(visited, x, y, 3);
					search(cctvnum + 1, visited);
					
					break;
				}
		}
}
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j ++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] >= 1 && map[i][j] <= 5)
					queue.add(new Point(i,j));
					//list.add(new Node(i, j, map[i][j]));
					
					
			}
		queue_size = queue.size();
		
		search(0, map);
		System.out.println(max_num);
	}
	public static class Node{
		int x;
		int y;
		int index;
		
		Node(int x, int y, int index){
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}
}

