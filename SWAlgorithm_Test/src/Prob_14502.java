import java.util.*;
import java.io.*;

public class Prob_14502 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int n, m;
	public static int [][] map;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++)
				bw.write(map[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
