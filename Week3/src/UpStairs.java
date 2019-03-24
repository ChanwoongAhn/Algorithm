import java.util.*;

public class UpStairs {
   static int[][] d;
   static int[] num;
   
   public static int dp(int n, int time) {      
	      if (n == 2) {				//종료 조건
	    	  if(time == 2)			//연속으로 2계단을 내려왔을 때
	    		  return num[2];	//현재 자신의 위치인 2번째 위치 값만 더해줌
	    	  else							//한 계단을 건너서 내려왔을 때
	    		  return num[2] + num[1];	//현재 자신의 위치와 그 앞의 위치도 갈수 있으므로 두 값을 더해줌
	      }
	      else if(n ==1)			//n의 값이 1인 경우
	    	  return num[1];
	      else if(n < 0)					//시작지점을 건너 뛰었을 때
	         return Integer.MIN_VALUE;
	      
	      if(d[n][time] > 0)		//메모이제이션
	         return d[n][time];
	      //재귀조건
	      if(time == 2)							//연속해서 2계단을 내려온 경우
	         d[n][time] = dp(n-2, 1) + num[n];	//다음 계단은 갈 수 없으므로 n-2, time은 1로, 자기 자신 값을 더해줌
	      else									//1계단을 내려온 경우
	         d[n][time] = Math.max(dp(n-1,time+1), dp(n-2, 1)) + num[n];
	      	 //다음 계단을 내려갈 지, 한 계단을 건너 뛸 지를 최대값을 구하여 결정함
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
