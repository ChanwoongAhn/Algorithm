import java.awt.Point;
import java.util.*;
import java.util.Queue;

public class BFS_USE_QUEUE {
	public static Scanner sc = new Scanner(System.in);
	public static Queue <Point> queue = new LinkedList<Point>();
	public static int n, cnt = 1;
	public static int [][] map;
	public static int [] l;
	
	public static void length(int _l) {
		l[cnt] = _l;
		cnt ++;
	}
	public static void BFS(int x, int y) {
		int pos = 0;
		queue.add(new Point(x,y));
		
		while(pos < cnt && (queue.peek().x != n - 1 || queue.peek().y != n - 1)) {
			int _x = queue.peek().x;
			int _y = queue.peek().y;
			System.out.println(queue.poll());
			//지나갔던 길 막기
			map[_x][_y] = 0;
			
			//위	
			if((_x > 0) && (map[_x - 1][_y] == 1)) {
				System.out.println("UP");
				System.out.println(queue.size());
				length(l[pos] + 1);
				queue.add(new Point(_x - 1, _y));
			}
			//아래
			if((_x < n - 1) && (map[_x + 1][_y] == 1)) {
				System.out.println("DOWN");
				System.out.println(queue.size());
				length(l[pos] + 1);
				queue.add(new Point(_x + 1, _y));
			}
			//좌
			if((_y > 0) && (map[_x][_y - 1] == 1)) {
				System.out.println("LEFT");
				System.out.println(queue.size());
				length(l[pos] + 1);
				queue.add(new Point(_x, _y - 1));
			}
			//우
			if((_y < n - 1) && (map[_x][_y + 1] == 1)) {
				System.out.println("RIGHT");
				System.out.println(queue.size());
				length(l[pos] + 1);
				queue.add(new Point(_x, _y + 1));
			}
			pos ++;
		}
		
		if(pos < cnt) {
			for(int i = 0; i < pos; i ++)
				System.out.print(l[i] + " ");
			System.out.println("최단 경로의 길이 : " +l[pos]);	
			
			while(!queue.isEmpty())
				System.out.println(queue.poll());
		}
	}
	public static void main(String[] args) {
		System.out.print("Enter n : ");
		n = sc.nextInt();
		
		map = new int[n][n];
		l = new int[n*n];
		
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++)
				map[i][j] = sc.nextInt();
		BFS(0,0);
	}

}