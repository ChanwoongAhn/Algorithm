import java.io.*;

public class Prob_2775 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int [][] arr = new int[15][14];
	
	public static void makearr() {
		for(int i = 0; i < 14; i ++) {
			arr[0][i] = i + 1;
		}
		for(int i = 1; i < 15; i ++) {
			for(int j = 0; j < 14; j ++) {
				for(int k = 0; k <= j; k ++) {
					arr[i][j] += arr[i-1][k];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		makearr();
		
		while(testcase -- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			bw.write(arr[k][n-1] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
