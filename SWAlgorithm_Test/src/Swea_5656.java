import java.util.*;
import java.util.Queue;
import java.awt.Point;

public class Swea_5656 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static int h;
	public static int w;
	public static int [][] arr;
	public static int [][] temp_arr;
	public static Queue <Integer> queue = new LinkedList<Integer>();
	public static Queue <Point> q = new LinkedList<Point>();
	
	public static void sort() {
		for(int i = 0; i < w; i++) {
			int cnt = 0;
			for(int j = 0; j < h; j++) {
				if(arr[j][i] != 0) {
					queue.add(arr[j][i]);
					arr[j][i] = 0;
					cnt ++;
				}
			}
			for(int j = h - cnt; j < h; j ++)
				arr[j][i] = queue.poll();
		}
	}
	
	public static void printarr() {
		for(int i = 0; i < h; i ++) {
			for(int j = 0; j < w; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int count_brick() {
		int sumofbrick = 0;
		
		for(int i = 0; i < h; i ++)
			for(int j = 0; j < w; j ++)
				if(arr[i][j] != 0)
					sumofbrick ++;
		return sumofbrick;
	}
	public static void initialize_arr() {
		for(int i = 0; i < h; i ++)
			for(int j = 0; j < w; j ++)
				arr[i][j] = temp_arr[i][j];
	}
	public static void DFS(int a) {	//한 번의 Step, a번째 열에 대해 탐색
		int pos = 0;
		
		for(int i = 0; i < h; i++){
			if(arr[i][a] != 0) {
				pos = i;
				break;
			}
		}

		q.add(new Point(pos,a));	//모든 열의 값이 0인 경우 -> brick_cnt = 0.
		
		while(!q.isEmpty()) {
			int tmp_x = q.peek().x;
			int tmp_y = q.poll().y;
			
			if(arr[tmp_x][tmp_y] > 1) {
				int tmp = arr[tmp_x][tmp_y] - 1;
				int z = 0;
				//좌
				if(tmp_y - tmp < 0)
					z = 0;
				else
					z = tmp_y - tmp;
				for(int j = z; j < tmp_y; j ++) {
					if(arr[tmp_x][j] != 0)
						q.add(new Point(tmp_x, j));
				}
				//우
				if(tmp_y + tmp >= w)
					z = w - 1;
				else
					z = tmp_y + tmp;
				for(int j = tmp_y + 1; j <= z; j++) {
					if(arr[tmp_x][j] != 0)
						q.add(new Point(tmp_x, j));
				}
				//상
				if(tmp_x - tmp < 0)
					z = 0;
				else
					z = tmp_x - tmp;
				for(int j = z; j < tmp_x; j ++)
					if(arr[j][tmp_y] != 0)
						q.add(new Point(j, tmp_y));
				//하
				if(tmp_x + tmp >= h)
					z = h - 1;
				else
					z = tmp_x + tmp;
				for(int j = tmp_x + 1; j <= z; j++) {
					if(arr[j][tmp_y] != 0)
						q.add(new Point(j, tmp_y));
				}
				arr[tmp_x][tmp_y] = 0;
			}
			else
				arr[tmp_x][tmp_y] = 0;
		}
		sort();
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int min_num = 100;
			
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			
			arr = new int[h][w];
			temp_arr = new int[h][w];
			
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
					temp_arr[i][j] = arr[i][j];
				}
			//DFS는 n번 해야됨 **수정***
			
			if( n == 1) {
				for(int k = 0; k < w; k ++) {
					DFS(k);
					int count = count_brick();
					if(count < min_num)
						min_num = count;

					initialize_arr();
				}
			}
			else if(n == 2) {
				for(int j = 0; j < w; j ++)
					for(int k = 0; k < w; k ++) {
						DFS(j);
						DFS(k);
						int count = count_brick();
						if(count < min_num)
							min_num = count;

						initialize_arr();
					}
			}
			else if(n == 3) {
				for(int i = 0; i < w; i ++)
					for(int j = 0; j < w; j ++)
						for(int k = 0; k < w; k ++) {
							DFS(i);
							DFS(j);
							DFS(k);
							int count = count_brick();
							if(count < min_num)
								min_num = count;

							initialize_arr();
						}
			}
			else {
				for(int a = 0; a < w; a ++)
					for(int i = 0; i < w; i ++)
						for(int j = 0; j < w; j ++)
							for(int k = 0; k < w; k ++) {
								DFS(a);
								DFS(i);
								DFS(j);
								DFS(k);
								int count = count_brick();
								if(count < min_num)
									min_num = count;

								initialize_arr();
							}
			}
			System.out.println("#" + (order_label++) + " " +min_num);
		}
	}
}
