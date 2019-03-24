import java.util.*;
import java.io.*;
public class Prob_3190 {
   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   public static StringTokenizer st;
   public static int n;
   public static int [][] map;
   public static char [] direction;
   public static int [] time;
   public static int sec = 0;
   public static int [] dx = {-1, 0, 1, 0};
   public static int [] dy = {0, 1, 0, -1};
   
   
   // ���� ���̸� �迭�� ���Ҹ� �ٸ��� �Ͽ� ǥ��
   // ���� ĭ�� 9�� �ٲ�, ���� ĭ�� ����� ���� ĭ�� ����, �ƴ� ��� ���� ĭ�� 0���� �ٲ���
   // ��� ĭ => 1, ���� ��ġ => 9
   public static void DFS(int x, int y, int direc, int next_x, int next_y) {
	   
   }
   public static void main(String [] args) throws IOException {
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      
      int app_num = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < app_num; i ++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         
         map[x-1][y-1] = 1;
      }
      
      time = new int[Integer.parseInt(br.readLine())];
      direction = new char[time.length];
      
      for(int i = 0; i < time.length; i ++) {
         st = new StringTokenizer(br.readLine());
         time[i] = Integer.parseInt(st.nextToken());
         direction[i] = st.nextToken().charAt(0);
      }
      
      //��� �׽�Ʈ
      bw.write("MAP\n");
      for(int i = 0; i < n; i ++) {
         for(int j = 0; j < n; j ++) {
            bw.write(map[i][j] + " ");
         }
         bw.write("\n");
      }

      bw.write("direction & time\n");
      for(int i = 0; i < time.length; i ++)
         bw.write(time[i] + " " + direction[i] + "\n");
      
      bw.flush();
      bw.close();
   }
}