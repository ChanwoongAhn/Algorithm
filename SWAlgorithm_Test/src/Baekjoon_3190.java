//��

import java.util.*;
import java.io.*;
import java.awt.*;

public class Baekjoon_3190 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int n;
	public static int [][] map;
	public static char [] direction;	//������ȯ �迭
	public static int [] time;
	public static char [] info;
	public static int result = 0;
	public static int cur_x = 0;
	public static int cur_y = 0;
	public static char cur_direction = 'R';
	public static Queue <Point> queue = new LinkedList<Point>();
	// direction = {U, R, D, L}
	// ��� = 1, ���� ��ġ = 9
	// ���� ���̸� �迭�� ���Ҹ� �ٸ��� �Ͽ� ǥ��
	// ���� ĭ�� 9�� �ٲ�, ���� ĭ�� ����� ���� ĭ�� ����, �ƴ� ��� ���� ĭ�� 0���� �ٲ���
	public static boolean simul(int x, int y, int direc) {
		boolean flag = true;
		int next_x = 0;
		int next_y = 0;
		
		switch(direc) {
			case 'D' :	//���������� Ʋ��
				//���� ������ �����
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
			case 'L' :	//�������� Ʋ��
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
			default :	//������ȯ ���� ���
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
		//���� �ε��� ���
		if(next_x < 0 || next_x >= n ||next_y < 0 || next_y >= n)
			flag = false;
		
		//���� ���� �ε��� ���
		else if(map[next_x][next_y] == 9)
			flag = false;
		
		//�� ���� ���
		else {
			//���� ĭ�� ����� ���
			if(map[next_x][next_y] == 1) {
				queue.add(new Point(next_x, next_y));
				map[next_x][next_y] = 9;
			}
			//���� ĭ�� ����� �ƴ� ��� -> �� ���̸� ���δ�.
			else {
				queue.add(new Point(next_x, next_y));
				map[next_x][next_y] = 9;
				map[queue.peek().x][queue.poll().y] = 0;	//���� ���̱�.
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
				
		//�� ó�� ���� �� ť�� 0,0 �־��ֱ�.
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

