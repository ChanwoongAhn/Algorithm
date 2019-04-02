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
   
   //톱니바퀴 돌리기
   public static void turn_cycle(int n, int d){   // 몇번째 톱니인지, 돌릴방향 1-> 시계
      int tmp;
      
      if(d == 1) {	//시계방향 돌리기
	      tmp = arr[n][7];
	      
	      for(int i = 7; i > 0; i --)
	         arr[n][i] = arr[n][i - 1];
	      arr[n][0] = tmp;
      }
      
      else if(d == -1) {	//반시계방향 돌리기
    	   tmp = arr[n][0];
	   
	   for(int i = 0; i < 7; i ++)
		   arr[n][i] = arr[n][i+1];
	   arr[n][7] = tmp;
      }
   }
   
   public static boolean check(int n, int d) {	//n -> 톱니 번호, d -> 1은 오른쪽톱니, -1은 왼쪽톱니와 비교
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
	   int [] direction = new int[4];	//각 톱니바퀴를 회전시킬지. 회전시킨다면 방향성
	   int [] odd_d = {d, -d, d, -d};	//홀수 톱니바퀴가 매개변수로 들어왓을떄
	   int [] even_d = {-d, d, -d, d};	//짝수
	  
	   switch(o) {
	   		case 0 :
	   			for(int i = 0; i < 3; i ++) {
	   				if(check(i, 1)) {
	   					if(direction[i] == 0) {	//다음 루프에서 값이 바뀌는 것을 방지
	   						direction[i] = odd_d[i];
	   					}
	   					direction[i+1] = odd_d[i+1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = odd_d[o];	//다 상극이어도 해당 톱니바퀴는 회전하도록
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
	   					if(direction[i] == 0) {	//다음 루프에서 값이 바뀌는 것을 방지
	   						direction[i] = even_d[i];
	   					}
	   					direction[i-1] = even_d[i-1];
	   				}
	   				else
	   					break;
	   			}
	   			direction[o] = even_d[o];	//다 상극이어도 해당 톱니바퀴는 회전하도록
	   			break;
	   }
	   //톱니바퀴 회전
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