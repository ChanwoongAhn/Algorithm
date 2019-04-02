import java.util.*;
import java.io.*;

public class Prob_1406 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int n;
	public static String [] order;
	public static String [] alpha;
	public static String word = "";
	public static int cursor;
	
	public static void main(String[] args) throws IOException {
		word = br.readLine();
		n = Integer.parseInt(br.readLine());
		order = new String[n];
		alpha = new String[n];
		
		cursor = word.length();
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			order[i] = tmp;
			if(order[i].charAt(0) == 'P') {
				tmp = st.nextToken();
				alpha[i] = tmp;
			}
			else
				alpha[i] = "";
		}
		
		for(int i = 0; i < n; i ++) {
			bw.write(order[i] + " : " + alpha[i] + "\n");
		}
		
		for(int i = 0; i < n; i ++) {
			switch(order[i].charAt(0)) {
				case 'L' :
					if(cursor != 0)
						cursor --;
					break;
				case 'D' :
					if(cursor != word.length())
						cursor ++;
					break;
				case 'B' :
					if(cursor != 0) {
						word = word.substring(0, cursor - 1) + word.substring(cursor);
						cursor --;
					}
					break;
				case 'P' :
					word = word.substring(0, cursor) + alpha[i] + word.substring(cursor);
					cursor ++;
					break;
			}
		}
		bw.write(word + "");
		bw.flush();
		bw.close();
			
	}
}
