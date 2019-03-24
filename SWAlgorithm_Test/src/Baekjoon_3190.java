//뱀

import java.util.*;
import java.io.*;
import java.awt.*;

public class Baekjoon_3190 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int n;
	public static int [][] map;
	public static char [] direction;	//방향전환 배열
	public static int [] time;
	public static char [] info;
	public static int result = 0;
	public static int cur_x = 0;
	public static int cur_y = 0;
	public static char cur_direction = 'R';
	public static Queue <Point> queue = new LinkedList<Point>();
	// direction = {U, R, D, L}
	// 사과 = 1, 뱀의 위치 = 9
	// 뱀의 길이를 배열의 원소를 다르게 하여 표현
	// 다음 칸을 9로 바꿈, 다음 칸이 사과면 꼬리 칸을 유지, 아닌 경우 꼬리 칸을 0으로 바꿔줌
	public static boolean simul(int x, int y, int direc) {
		boolean flag = true;
		int next_x = 0;
		int next_y = 0;
		
		switch(direc) {
			case 'D' :	//오른쪽으로 틀기
				//이전 방향을 고려함
				switch(cur_direction) {
					case 'U' : 
						next_x = x;
						next_y = y + 1;
						cur_direction = 'R';
						break;
					case 'R' :
						next_x = x + 1;
						next_y = y;
						cur_direction = 'D';
						break;
					case 'D' :
						next_x = x;
						next_y = y - 1;
						cur_direction = 'L';
						break;
					case 'L' :
						next_x = x - 1;
						next_y = y;
						cur_direction = 'U';
						break;
				}
				break;
			case 'L' :	//왼쪽으로 틀기
				switch(cur_direction) {
				case 'U' :
					next_x = x;
					next_y = y - 1;
					cur_direction = 'L';
					break;
				case 'R' :
					next_x = x - 1;
					next_y = y;
					cur_direction = 'U';
					break;
				case 'D' :
					next_x = x;
					next_y = y + 1;
					cur_direction = 'R';
					break;
				case 'L' :
					next_x = x + 1;
					next_y = y;
					cur_direction = 'D';
					break;
				}
				break;
			default :	//방향전환 없는 경우
				switch(cur_direction) {
					case 'U' :
						next_x = x - 1;
						next_y = y;
						break;
					case 'R' :
						next_x = x;
						next_y = y + 1;
						break;
					case 'D' :
						next_x = x + 1;
						next_y = y;
						break;
					case 'L' :
						next_x = x;
						next_y = y - 1;
						break;
				}
		}
		//벽에 부딪힌 경우
		if(next_x < 0 || next_x >= n ||next_y < 0 || next_y >= n)
			flag = false;
		
		//뱀의 몸에 부딪힌 경우
		else if(map[next_x][next_y] == 9)
			flag = false;
		
		//그 외의 경우
		else {
			//다음 칸이 사과인 경우
			if(map[next_x][next_y] == 1) {
				queue.add(new Point(next_x, next_y));
				map[next_x][next_y] = 9;
			}
			//다음 칸이 사과가 아닌 경우 -> 몸 길이를 줄인다.
			else {
				queue.add(new Point(next_x, next_y));
				map[next_x][next_y] = 9;
				map[queue.peek().x][queue.poll().y] = 0;	//꼬리 줄이기.
			}
			cur_x = next_x;
			cur_y = next_y;
		}
		return flag;
	}
	
	public static void main(String [] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		int app_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < app_num; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x-1][y-1] = 1;
		}
		
		time = new int[Integer.parseInt(br.readLine())];
		direction = new char[time.length];
		info = new char[n*n];
		
		for(int i = 0; i < time.length; i ++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			direction[i] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i < time.length; i ++)
			info[time[i]] = direction[i];
				
		//맨 처음 동작 시 큐에 0,0 넣어주기.
		queue.add(new Point(0, 0));
		map[0][0] = 9;
		
		for(int i = 0; i < n*n; i ++) {
			if(!simul(cur_x,cur_y, info[i])) {
				result ++;
				break;
			}
			result ++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

