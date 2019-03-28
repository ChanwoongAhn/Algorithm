import java.util.*;
import java.io.*;

public class Prob_10250 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int [][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		int h;
		int w;
		int n;
		String result;
		
		while(testcase -- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			result = "";
			int room_h;
			int room_w;
			
			arr = new int[h][w];
						
			if(n%h == 0) {
				room_h = h;
				room_w = n / h;
			}
			else {
				room_h = n % h;
				room_w = n / h + 1;
			}
			if(room_w < 10)
				result += (int)room_h + "0" + (int)room_w;
			else
				result += (int)room_h + "" + (int)room_w;
			
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}

}
