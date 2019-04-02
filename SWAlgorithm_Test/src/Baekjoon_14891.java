import java.util.*;
import java.io.*;

public class Baekjoon_14891 {
   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   public static StringTokenizer st;
   public static int [][] arr = new int[4][8];   
   public static int k;
   public static int [] order;
   public static int [] direc;
   
   //��Ϲ��� ������
   public static void turn_cycle(int n, int d){   // ���° �������, �������� 1-> �ð�
      int tmp;
      
      if(d == 1) {	//�ð���� ������
	      tmp = arr[n][7];
	      
	      for(int i = 7; i > 0; i --)
	         arr[n][i] = arr[n][i - 1];
	      arr[n][0] = tmp;
      }
      
      else if(d == -1) {	//�ݽð���� ������
    	   tmp = arr[n][0];
	   
	   for(int i = 0; i < 7; i ++)
		   arr[n][i] = arr[n][i+1];
	   arr[n][7] = tmp;
      }
   }
   
   public static boolean check(int n, int d) {	//n -> ��� ��ȣ, d -> 1�� ���������, -1�� ������Ͽ� ��
	   boolean flag = false;
	   
	   switch(d) {
	   		case -1 :
	   			if(arr[n][6] != arr[n-1][2])
	   				flag = true;
	   			break;
	   		case 1 :
	   			if(arr[n][2] != arr[n+1][6])
	   				flag = true;
	   			break;
	   }
	   
	   return flag;
   }
   
   public static void turn(int o, int d) throws IOException{
	   int [] direction = new int[4];	//�� ��Ϲ����� ȸ����ų��. ȸ����Ų�ٸ� ���⼺
	   int [] odd_d = {d, -d, d, -d};	//Ȧ�� ��Ϲ����� �Ű������� ��������
	   int [] even_d = {-d, d, -d, d};	//¦��
	  
	   switch(o) {
	   		case 0 :
	   			for(int i = 0; i < 3; i ++) {
	   				if(check(i, 1)) {
	   					if(direction[i] == 0) {	//���� �������� ���� �ٲ�� ���� ����
	   						direction[i] = odd_d[i];
	   					}
	   					direction[i+1] = odd_d[i+1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = odd_d[o];	//�� ����̾ �ش� ��Ϲ����� ȸ���ϵ���
	   			break;
	   			
	   		case 1 :
	   			if(check(0, 1)) {
	   				direction[0] = even_d[0];
	   				direction[1] = even_d[1];
	   			}
	   			
	   			for(int i = 1; i < 3; i ++) {
	   				if(check(i, 1)) {
	   					if(direction[i] == 0) {
	   						direction[i] = even_d[i];
	   					}
	   					direction[i+1] = even_d[i+1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = even_d[o];
	   			break;		
	   			
	   		case 2 :
	   			if(check(2, 1)) {
	   				direction[3] = odd_d[3];
	   				direction[2] = odd_d[2];
	   			}
	   			
	   			for(int i = 2; i > 0; i --) {
	   				if(check(i, -1)) {
	   					if(direction[i] == 0) {
	   						direction[i] = odd_d[i];
	   					}
	   					direction[i-1] = odd_d[i-1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = odd_d[o];
	   			break;
	   			
	   		case 3 :
	   			for(int i = 3; i > 0; i --) {
	   				if(check(i, -1)) {
	   					if(direction[i] == 0) {	//���� �������� ���� �ٲ�� ���� ����
	   						direction[i] = even_d[i];
	   					}
	   					direction[i-1] = even_d[i-1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = even_d[o];	//�� ����̾ �ش� ��Ϲ����� ȸ���ϵ���
	   			break;
	   }
	   //��Ϲ��� ȸ��
	   for(int i = 0; i < 4; i ++) {
		   turn_cycle(i, direction[i]);
	   }
   }
   
   public static int getscore() {
	   int result = 0;
	   
	   for(int i = 0; i < 4; i ++) {
		   if(arr[i][0] == 1)
			   result += Math.pow(2, i);
	   }
	   return result;
   }
   public static void main(String[] args) throws IOException {
      for(int i = 0; i < 4; i ++) {
         String tmp = br.readLine();
         for(int j = 0; j < 8; j ++)
            arr[i][j] = tmp.charAt(j) - 48;
      }
      k = Integer.parseInt(br.readLine());
      order = new int[k];
      direc = new int[k];
      
      for(int i = 0; i < k; i ++) {
         st = new StringTokenizer(br.readLine());
         order[i] = Integer.parseInt(st.nextToken());
         direc[i] = Integer.parseInt(st.nextToken());
      }
      for(int i = 0; i < k; i ++) {
    	  turn(order[i] - 1, direc[i]);
      }
      bw.write(getscore() + "");
      bw.flush();
      bw.close();
   }
}