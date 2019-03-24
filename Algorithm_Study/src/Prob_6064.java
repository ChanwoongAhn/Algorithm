import java.util.*;
import java.io.*;

public class Prob_6064 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int testcase = Integer.parseInt(br.readLine());
		int M, N, x, y;
		int result;
		int i, j;
		
		while(testcase -- > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			result = 1; i = 0; j = 0;
			boolean flag = false;
			
			while(!(i == M && j == N)) {
				if(i < M)
					i += 1;
				else
					i = 1;
				
				if(j < N)
					j += 1;
				else
					j = 1;
				
				//bw.write("(" + i + ", " + j + ")");
				if(i == x && j == y) {
					flag = true;
					break;
				}
				else
					result ++;
			}
			
			if(flag)
				bw.write(result + "\n");
			else
				bw.write("-1\n");
			
		}
		bw.flush();
		bw.close();
	}

}
