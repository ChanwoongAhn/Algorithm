import java.io.*;

public class Prob_2941 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String list[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0; i < list.length; i ++)
			input = input.replace(list[i], "a");
		
		bw.write(input.length() + "");
		bw.flush();
		bw.close();
	}
}

//string.replace(a,b)
//string 문자열의 a 원소를 모두 b로 바꿔줌
