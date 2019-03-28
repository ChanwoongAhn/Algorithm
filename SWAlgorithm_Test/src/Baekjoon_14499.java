import java.util.*;
import java.io.*;

public class Baekjoon_14499 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int n;
	public static int m;
	public static int x;
	public static int y;
	public static int [][] map;
	public static int [] order;
	public static int [][] dice = new int[4][3];
	
	public static boolean roll_dice(int direc) {
		boolean result = false;
		int tmp1;
		int tmp2;
		
		//주사위 굴리기
		switch(direc) {
			//동쪽으로 굴리기
			case 1 :
				if(y < m - 1) {
					tmp1 = dice[1][2];
					dice[1][2] = dice[1][1];
					dice[1][1] = dice[1][0];
					tmp2 = dice[3][1];
					dice[3][1] = tmp1;
					dice[1][0] = tmp2;
					y += 1;
					result = true;
				}
				break;
			//서쪽으로 굴리기
			case 2 :
				if(y > 0) {
					tmp1 = dice[1][0];
					dice[1][0] = dice[1][1];
					dice[1][1] = dice[1][2];
					tmp2 = dice[3][1];
					dice[3][1] = tmp1;
					dice[1][2] = tmp2;
					y -= 1;
					result = true;
				}
				break;
			//북쪽으로 굴리기
			case 3 :
				if(x > 0) {
					tmp1 = dice[0][1];
					for(int i = 0; i < 3; i ++)
						dice[i][1] = dice[i+1][1];
					dice[3][1] = tmp1;
					x -= 1;
					result = true;
				}
				break;
			//남쪽으로 굴리기
			case 4 :
				if(x < n - 1) {
					tmp1 = dice[3][1];
					for(int i = 3; i > 0; i --)
						dice[i][1] = dice[i-1][1];
					dice[0][1] = tmp1;
					x += 1;
					result = true;
				}
				break;
		}
		
		if(map[x][y] == 0) {
			map[x][y] = dice[3][1];
		}
		else {
			dice[3][1] = map[x][y];
			map[x][y] = 0;
		}
		return result;
		
	}
	public static void main(String[] args) throws IOException {
		int k;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		order = new int[k];
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i ++)
			order[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i ++) {
			if(roll_dice(order[i]))
				bw.write(dice[1][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
