import java.io.*;

public class Prob_2750 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void sort(int n, int [] arr) {
		int tmp = 0;
		
		for(int i = 0; i < n; i ++) {
			for(int j = i + 1; j < n; j ++ ) {
				if(arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(n, arr);
		
		for(int i = 0; i < n; i ++)
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
	}
}
