import java.util.*;
import java.io.*;

public class Prob_2292 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int [] arr = new int[100000];
		arr[0] = 1;
		for(int i = 1; i < arr.length; i ++) {
			arr[i] = arr[i-1] + 6*(i-1);
		}
		
		int n = Integer.parseInt(br.readLine());
		int layer = 0;

		for(int i = 1; i < arr.length; i ++) {
			if(arr[i] >= n) {
				layer = i;
				break;
			}
		}

		bw.write(layer + "");
		bw.flush();
		bw.close();
	}
}
