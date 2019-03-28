import java.io.*;
import java.util.*;

public class Prob_2908 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		
		String changed_num1 = "" + num1.charAt(2) + num1.charAt(1) + num1.charAt(0);
		String changed_num2 = "" + num2.charAt(2) + num2.charAt(1) + num2.charAt(0);
		
		if(Integer.parseInt(changed_num1) > Integer.parseInt(changed_num2))
			bw.write(changed_num1);
		else
			bw.write(changed_num2);
		bw.flush();
		bw.close();
	}
}
