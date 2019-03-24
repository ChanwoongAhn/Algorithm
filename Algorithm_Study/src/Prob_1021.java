import java.util.*;
import java.io.*;

public class Prob_1021 {
   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   public static StringTokenizer st;
   public static int [] arr;
   public static int [] num;
   public static int n;
   public static int size;
   public static int cursor = 0;   //���� ����Ű�� �ִ� �迭 �ε����� ��ġ
   public static int result = 0;
   
   //���� ��ġ���� �ش� �� ������ �Ÿ�. direction�� -1 -> ��, 1 -> �� ����
   public static int getdist(int direction, int number) {
      int dist = 0;
      if(arr[cursor] == number)
         return dist;
      //���� ����
      else if(direction == 1) {
         for(int i = 1; i < n ; i ++) {
            int tmp = (cursor + i) % n;
            if(arr[tmp] == number) {
               dist ++;
               break;
            }
            else {
               if(arr[tmp] != 0)
                  dist ++;
            }
         }
      }
      //���� ����
      else{
         for(int i = -1; i > -n; i --) {
            int tmp;
            if(cursor + i < 0)
               tmp = (cursor + i + n) % n;
            else
               tmp = (cursor + i) % n;
            
            if(arr[tmp] == number) {
               dist ++;
               break;
            }
            else {
               if(arr[tmp] != 0)
                  dist ++;
            }
         }
      }
      return dist;
   }
   public static void main(String[] args) throws IOException {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      size = Integer.parseInt(st.nextToken());
      
      arr = new int[n];
      num = new int[size];
      
      for(int i = 0; i < n; i ++)
         arr[i] = i + 1;
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < size; i ++)
         num[i] = Integer.parseInt(st.nextToken());
      
      int k = 0;
      while(size -- > 0) {
         int number = num[k++];

         System.out.println("Cursor : " + cursor);
         System.out.println("Num : " + number);
         System.out.println("L : " +getdist(-1, number));
         System.out.println("R : " +getdist(1, number));
      
         //���� ��ΰ� �� ª����
         if(getdist(-1, number) <= getdist(1, number)) {
            result += getdist(-1, number);
            cursor += getdist(-1, number);
            cursor %= n;
            arr[cursor] = 0;
         }
         else if(getdist(-1, number) > getdist(1, number)) {
            result += getdist(1, number);
            cursor += getdist(1, number);
            cursor %= n;
            arr[cursor] = 0;
         }
         cursor = (cursor + 1) % n;
         System.out.println("Result : " + result);
      }
      
      bw.write(result + "");
      bw.flush();
      bw.close();
   }

}