import java.io.*;
import java.util.*;

public class Prob_1011 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		int x;
		int y;
				
		for(int i = 0; i < testcase; i ++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			
			y = y - x;
			x = x - x;
			int n;
			
			for(n = 1; x <= y/2; n ++) {
				x += n;
			}

			if(y - x == n*(n+1)/2)
				n *= 2;
			
			bw.write("x : " +x +", y : " + y + "\n");
		}
		bw.flush();
		bw.close();
	}

}
