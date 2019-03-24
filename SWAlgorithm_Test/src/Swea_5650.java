import java.util.*;

public class Swea_5650 {
	public static Scanner sc = new Scanner(System.in);
	public static int [][] arr;
	
	public static int getpoint(int x, int y, int n, int d) {
		int point = 0;
		int direction = d;
		int start_x = x;
		int start_y = y;
		
		while(arr[x][y] != -1 && arr[start_x][start_y] == 0) {
			//¹æÇâ¼³Á¤ ¹× ÀÌµ¿ (º®¿¡ ºÎµúÈù °æ¿ì ÆÄ¾Ç)
			if(direction == 0) {
				if(x > 0)
					x -= 1;
				else {
					direction = 1;
					point ++;
				}
			}
			else if(direction == 1) {
				if(x < n - 1)
					x += 1;
				else {
					direction = 0;
					point ++;
				}
			}
			else if(direction == 2) {
				if(y > 0)
					y -= 1;
				else {
					direction = 3;
					point ++;
				}	
			}
			else if(direction == 3) {
				if(y < n - 1)
					y += 1;
				else {
					direction = 2;
					point ++;
				}
			}
			
			if(arr[x][y] >= 1 && arr[x][y] <= 5) {
				if(arr[x][y] == 1) {
					if(direction == 3) {
						point ++;
						direction = 2;
					}
					else if(direction == 0) {
						point ++;
						direction = 1;
					}
					else if(direction == 1) {
						point ++;
						direction = 3;
					}
					else if(direction == 2) {
						point ++;
						direction = 0;
					}
				}
				else if(arr[x][y] == 2) {
					if(direction == 0) {
						point ++;
						direction = 3;
					}
					else if(direction == 1) {
						point ++;
						direction = 0;
					}
					else if(direction == 2) {
						point ++;
						direction = 1;
					}
					else if(direction == 3) {
						point ++;
						direction = 2;
					}
				}
				else if(arr[x][y] == 3) {
					if(direction == 0) {
						point ++;
						direction = 2;
					}
					else if(direction == 1) {
						point ++;
						direction = 0;
					}
					else if(direction == 2) {
						point ++;
						direction = 3;
					}
					else if(direction == 3) {
						point ++;
						direction = 1;
					}
				}
				else if(arr[x][y] == 4) {
					if(direction == 0) {
						point ++;
						direction = 1;
					}
					else if(direction == 1) {
						point ++;
						direction = 2;
					}
					else if(direction == 2) {
						point ++;
						direction = 3;
					}
					else if(direction == 3) {
						point ++;
						direction = 0;
					}
				}
				else if(arr[x][y] == 5) {
					if(direction == 0) {
						point ++;
						direction = 1;
					}
					else if (direction == 1) {
						point ++;
						direction = 0;
					}
					else if(direction == 2) {
						point ++;
						direction = 3;
					}
					else if(direction == 3) {
						point ++;
						direction = 2;
					}
				}
			}
			//¿úÈ¦
			else if(arr[x][y] <= 10 && arr[x][y] >= 6) {
				int tmp_x = 0;
				int tmp_y = 0;
				
				for(int i = 0; i < n; i ++) 
					for(int j = 0; j < n; j ++) {
						if((arr[i][j] == arr[x][y]) && !(x == i && y == j)) {
							tmp_x = i;
							tmp_y = j;
							break;
						}
					}
				x = tmp_x;
				y = tmp_y;
			}
			if(x == start_x && y == start_y)
				break;
		}
		
		return point;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int max_point = 0;
			int n = sc.nextInt();
			arr = new int[n][n];
			
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < n; j ++)
					arr[i][j] = sc.nextInt();
			
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < n; j ++) {
					int tmp = 0;
					for(int k = 0; k < 4; k ++) {
						if(tmp < getpoint(i,j,n,k)) {
							tmp = getpoint(i,j,n,k);
						}
					}
					if(tmp > max_point)
						max_point = tmp;
				}
			System.out.println("#" + (order_label++) + " " + max_point);
		}
	}
}
