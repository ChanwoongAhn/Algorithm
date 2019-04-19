//창용 마을 무리의 개수

import java.util.*;
import java.io.*;
public class Prob_7465 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int M, N;
	public static int [] arr;
	
	public static boolean check_element(int n) {
		boolean result = false;
		
		if(arr[n] != 0)
			result = true;
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int order_label = 1;
		
		
		for(int k = 0; k < T; k ++) {
			int count = 1;
			int result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			
			for(int i = 0; i < M; i ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//a 존재, b는 x
				if(check_element(a) && !check_element(b)) {
					//이웃임을 표현하기 위해 b 값의 자리에 a 값의 숫자를 넣어줌
					arr[b] = arr[a];
				}
				//a는 x, b는 존재
				else if(check_element(b) && !check_element(a)) {
					arr[a] = arr[b];
				}
				//둘 다 이미 존재하는 수면 -> 해당 관계 사람들을 하나로 통합(b의 수를 a의 수로 통일)
				else if(check_element(a) && check_element(b)) {
					int tmp = arr[b];
					for(int j = 0; j < N + 1; j ++) {
						if(arr[j] == tmp)
							arr[j] = arr[a];
					}
				}
				//둘 다 처음 등장하는 값인 경우
				else {
					arr[a] = count;
					arr[b] = count;
					count ++;
				}
			}
			
			for(int i = 1; i < N + 1; i ++) {
				if(arr[i] > 0) {
					result ++;
					for(int j = i + 1; j < N + 1; j ++) 
						if(arr[j] == arr[i]) 
							arr[j] = -1;
					arr[i] = -1;
				}
				else if(arr[i] == 0)
					result ++;
			}
			bw.write("#" + (order_label ++) + " " + result + "\n");
			
		}
		bw.flush();
		bw.close();	
	}

}
