import java.io.*;
import java.util.*;

public class Prob_1316 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int [] arr;
	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		int result = 0;
		String word;
		while(testcase -- > 0) {
			arr = new int[26];
			word = br.readLine();
			
			//arr[word.charAt(0) - 97] ++;
			for(int i = 0; i < word.length(); i ++) {
				if(arr[word.charAt(i) - 97] != 0) {
					if(i > 0 && (word.charAt(i - 1) == word.charAt(i)))
							arr[word.charAt(i) - 97] ++;
					else
						break;
				}
				else
					arr[word.charAt(i) - 97] ++;
				
				if(i == word.length() - 1)
					result ++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();	
	}
}
