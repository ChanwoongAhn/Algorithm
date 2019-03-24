import java.util.*;

public class UpStairs {
   static int[][] d;
   static int[] num;
   
   public static int dp(int n, int time) {      
	      if (n == 2) {				//���� ����
	    	  if(time == 2)			//�������� 2����� �������� ��
	    		  return num[2];	//���� �ڽ��� ��ġ�� 2��° ��ġ ���� ������
	    	  else							//�� ����� �ǳʼ� �������� ��
	    		  return num[2] + num[1];	//���� �ڽ��� ��ġ�� �� ���� ��ġ�� ���� �����Ƿ� �� ���� ������
	      }
	      else if(n ==1)			//n�� ���� 1�� ���
	    	  return num[1];
	      else if(n < 0)					//���������� �ǳ� �پ��� ��
	         return Integer.MIN_VALUE;
	      
	      if(d[n][time] > 0)		//�޸������̼�
	         return d[n][time];
	      //�������
	      if(time == 2)							//�����ؼ� 2����� ������ ���
	         d[n][time] = dp(n-2, 1) + num[n];	//���� ����� �� �� �����Ƿ� n-2, time�� 1��, �ڱ� �ڽ� ���� ������
	      else									//1����� ������ ���
	         d[n][time] = Math.max(dp(n-1,time+1), dp(n-2, 1)) + num[n];
	      	 //���� ����� ������ ��, �� ����� �ǳ� �� ���� �ִ밪�� ���Ͽ� ������
	      return d[n][time];
   }
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      d = new int[n+1][3];
      num = new int[n+1];
      
      for(int i = 1; i <= n; i++) 
         num[i] = scan.nextInt();
      
      System.out.println(dp(n, 1));
   }
}
