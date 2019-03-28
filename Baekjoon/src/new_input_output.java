import java.io.*;
import java.util.*;

public class new_input_output {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());	//���� ���� ���ڿ��� �о�ͼ� ����(default ��) �������� ��ūȭ
		
		int n = Integer.parseInt(st.nextToken());	//ù ��ū�� n�� int����ȯ�ؼ� ����
		int x = Integer.parseInt(st.nextToken());	//�ι�° ��ū�� -
		
		st = new StringTokenizer(br.readLine());	//���� ���� ������ �о��
		
		while(st.hasMoreTokens()) {						//��ū�� �ִ¸�ŭ(n��)
			int tmp = Integer.parseInt(st.nextToken());	//���� �������� ������ ��ū�� ���ʷ� tmp�� ����
			if(tmp < x)
				bw.write(tmp + " ");
		}
		bw.flush();
		bw.close();
	}

}
