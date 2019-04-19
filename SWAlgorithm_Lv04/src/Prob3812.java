import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Prob3812 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i ++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(st.nextToken());
			
			BigInteger [] big = new BigInteger[N];
			
			for(int j = 0; j < N; j ++)
				big[j] = BigInteger.ZERO;
			for(int x = 0; x < X; x ++) {
				for(int y = 0; y < Y; y ++) {
					for(int z = 0; z < Z; z ++) {
						int tmp = (Math.abs(x-A) + Math.abs(y-B) + Math.abs(z-C)) % N;
						big[tmp] = big[tmp].add(BigInteger.ONE);
					}
				}
			}
			
			for(int j = 0; j < N; j ++)
				bw.write(big[j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
