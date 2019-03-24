import java.util.*;
import java.io.*;

public class Baekjoon_13458 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		for(int i = 0; i < n; i ++) {
			result += 1;
			arr[i] -= b;
			
			if(arr[i] % c != 0)
				result += (arr[i] / c + 1);
			else
				result += arr[i] / c;
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
}
