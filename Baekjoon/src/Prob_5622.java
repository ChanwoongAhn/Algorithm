import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob_5622 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String word = br.readLine();
		int time = 0;
		
		for(int i = 0; i < word.length(); i ++) {
			int tmp = word.charAt(i);
			if(tmp >= 65 && tmp <= 67)
				time += 3;
			else if(tmp >= 68 && tmp <= 70)
				time += 4;
			else if(tmp >= 71 && tmp <= 73)
				time += 5;
			else if(tmp >= 74 && tmp <= 76)
				time += 6;
			else if(tmp >= 77 && tmp <= 79)
				time += 7;
			else if(tmp >= 80 && tmp <= 83)
				time += 8;
			else if(tmp >= 84 && tmp <= 86)
				time += 9;
			else if(tmp >= 87 && tmp <= 90)
				time += 10;
		}
		
		bw.write(time + "\n");
		bw.flush();
		bw.close();
	}

}
