import java.io.*;

public class Prob_1475 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String num = br.readLine();
		int tmp;
		int [] arr = new int[9];
		int max_num = 0;
		
		for(int i = 0; i < num.length(); i ++) {
			tmp = num.charAt(i) - 48;
			
			if(tmp == 9)
				arr[6] ++;
			else
				arr[tmp] ++;
		}
		if(arr[6]%2 == 1) {
			arr[6] /= 2;
			arr[6] += 1;
		}
		else
			arr[6] /= 2;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] > max_num)
				max_num = arr[i];
		}
		bw.write(max_num + "\n");
		bw.flush();
		bw.close();
	}
}
