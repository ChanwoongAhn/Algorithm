import java.util.*;

public class Prob_2105 {
	public static Scanner sc = new Scanner(System.in);
	public static Queue <Integer> que = new LinkedList<Integer>();
	public static int [][] arr;
	
	public static int getresult(int n) {
		int max_desert = 0;
		int [] dx = {1, -1, -1, 1};
		int [] dy = {1, 1, -1, -1};
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++) {
				int desert = 0;
				int x = j;
				int y = i;
				
				int [] d_arr = new int[100];
				
				while(que.isEmpty()) {
					//L=1인 직사각형
					que.add(arr[i][j]);
					for(int k = 0; k < 4; k ++)
						que.add(arr[x+dx[k]][y+dy[k]]);
					while(!que.isEmpty()) {
						if(d_arr[que.poll()] != 0)
							break;
						else
							d_arr[que.poll()] ++;
					}
					
				}
				
			}
		
		if (max_desert == 0)
			return -1;
		else
			return max_desert;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase-- > 0) {
			int n = sc.nextInt();
			arr = new int[n][n];
			
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < n; j ++)
					arr[i][j] = sc.nextInt();
			
			
			
		}
	}
}
