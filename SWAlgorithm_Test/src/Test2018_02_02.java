import java.util.*;

public class Test2018_02_02 {
	public static Scanner sc = new Scanner(System.in);
	public static int l, r, n;
	public static int [][] map;
	
	public static void detect(int [][] visited) {
		int sum, cnt;
		int [][] tmp = new int[n][n];
		int num = 1;
		
		while(true) {
			sum = 0;
			cnt = 0;
			
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < n; j ++)
					tmp[i][j] = visited[i][j];
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					for(int k = 0; k < 2; k ++) {
						switch(k) {
							//го
							case 0 :
								if(i == n - 1)
									break;
								else {
									if((l <= Math.abs(map[i+1][j] - map[i][j]) && Math.abs(map[i+1][j] - map[i][j]) <= r) && (visited[i][j] == 0 || visited[i][j] == num)) {
										visited[i][j] = num;
										if(i == n - 2)
											visited[i+1][j] = num;
									}
								}
								break;
							//©Л	
							case 1 :
								if(j == n - 1)
									break;
								else {
									if((l <= Math.abs(map[i][j+1] - map[i][j]) && Math.abs(map[i][j+1] - map[i][j]) <= r) && (visited[i][j] == 0 || visited[i][j] == num)){
										visited[i][j] = num;
										if(j == n - 2)
											visited[i][j+1] = num;
									}
									else {
										j = n - 1;
									}
								}
								break;
						}
					}
				}
			}
			print_map(visited);
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					if(visited[i][j] == num) {
						sum += map[i][j];
						cnt ++;
					}
				}
			}
			if(cnt != 0)
				sum /= cnt;
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					if(visited[i][j] == num)
						map[i][j] = sum;
				}
			}
			if(check_arr(visited, tmp))
				break;
			else {
				num ++;
			}
			print_map(map);
			System.out.println(num);
		}
	}
	public static int search(int [][] map) {
		int level = 0;
		int [][] visited;
		int [][] tmp = new int[n][n];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++)
				tmp[i][j] = map[i][j];
		
		while(true) {
			visited = new int[n][n];
			for(int i = 0; i < n; i ++)
				for(int j = 0; j < n; j ++)
					tmp[i][j] = map[i][j];
			
			detect(visited);
			if(!check_arr(map, tmp))
				level ++;
			else
				break;
		}
		
		return level;
	}
	public static boolean check_arr(int [][] arr1, int [][] arr2) {
		boolean flag = true;
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j++) {
				if(arr1[i][j] != arr2[i][j]) {
					flag = false;
					break;
				}
			}
		return flag;
	}
	public static void print_map(int [][] map) {
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < n; j ++)
				map[i][j] = sc.nextInt();
		
		System.out.println(search(map));
	}

}
