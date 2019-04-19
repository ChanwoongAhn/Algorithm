//â�� ���� ������ ����

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
				
				//a ����, b�� x
				if(check_element(a) && !check_element(b)) {
					//�̿����� ǥ���ϱ� ���� b ���� �ڸ��� a ���� ���ڸ� �־���
					arr[b] = arr[a];
				}
				//a�� x, b�� ����
				else if(check_element(b) && !check_element(a)) {
					arr[a] = arr[b];
				}
				//�� �� �̹� �����ϴ� ���� -> �ش� ���� ������� �ϳ��� ����(b�� ���� a�� ���� ����)
				else if(check_element(a) && check_element(b)) {
					int tmp = arr[b];
					for(int j = 0; j < N + 1; j ++) {
						if(arr[j] == tmp)
							arr[j] = arr[a];
					}
				}
				//�� �� ó�� �����ϴ� ���� ���
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
