import java.util.*;

public class BFS_NOT_QUEUE {
	public static Scanner sc= new Scanner(System.in);
	public static int n, cnt;
	public static int [][] map = new int [10][10];
	public static int [] x = new int[100];
	public static int [] y = new int[100];
	public static int [] l = new int[100];
	
	public static void enqueue(int x_pos, int y_pos, int len) {
		x[cnt] = x_pos;
		y[cnt] = y_pos;
		l[cnt] = len;
		
		cnt ++;
	}
	public static void BFS(int x_pos, int y_pos) {
		int pos = 0;
		
		enqueue(x_pos, y_pos, 1);
		
		while((pos < cnt) && (x[pos] != n - 1 || y[pos] != n - 1)) {
			map[x[pos]][y[pos]] = 0;
			
			//위
			if((x[pos] > 0) && (map[x[pos] - 1][y[pos]] == 1)) {
				enqueue(x[pos] - 1, y[pos], l[pos] + 1);
				System.out.println("UP");
			}
			//아래
			if((x[pos] < n - 1) && (map[x[pos] + 1][y[pos]] == 1)) {
				enqueue(x[pos] + 1, y[pos], l[pos] + 1);
				System.out.println("Down");
			}
			//왼쪽
			if((y[pos] > 0) && (map[x[pos]][y[pos] - 1] == 1)) {
				enqueue(x[pos], y[pos] - 1, l[pos] + 1);
				System.out.println("Left");
			}
			//오른쪽
			if((y[pos] < n - 1) && (map[x[pos]][y[pos] + 1] == 1)) {
				enqueue(x[pos], y[pos] + 1, l[pos] + 1);
				System.out.println("Right");
			}
			pos ++;
		}
		
		if(pos < cnt) {
			System.out.println("최단 경로의 길이 : " +l[pos]);
			
			for(int i = 0; i <= pos; i ++) {
				System.out.printf("(%d,%d) , Length : %2d\n", x[i],y[i],l[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Enter n : ");
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		
		BFS(0,0);
	}
}
