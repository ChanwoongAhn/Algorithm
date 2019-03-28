import java.io.*;
import java.util.*;

public class new_input_output {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());	//다음 라인 문자열을 읽어와서 공백(default 값) 기준으로 토큰화
		
		int n = Integer.parseInt(st.nextToken());	//첫 토큰을 n에 int형변환해서 대입
		int x = Integer.parseInt(st.nextToken());	//두번째 토큰을 -
		
		st = new StringTokenizer(br.readLine());	//다음 라인 공백을 읽어옴
		
		while(st.hasMoreTokens()) {						//토큰이 있는만큼(n개)
			int tmp = Integer.parseInt(st.nextToken());	//공백 기준으로 끊어진 토큰을 차례로 tmp에 저장
			if(tmp < x)
				bw.write(tmp + " ");
		}
		bw.flush();
		bw.close();
	}

}
