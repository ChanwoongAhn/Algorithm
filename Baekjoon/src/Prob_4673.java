public class Prob_4673 {
public static int [] arr = new int[10000];
	
	public static void main(String[] args) {
		for(int i = 0; i < 10000; i ++) {
			String tmp = "" + i;
			if(i < 10)
				arr[i+i] = 1;
			else {
				int x = 0;
				for(int j = 0; j < tmp.length(); j ++)
					x += tmp.charAt(j) - 48;
				x += i;
				if(x < 10000)
					arr[x] = 1;
			}
		}
		
		for(int i = 0; i < 10000; i ++)
			if(arr[i] == 0)
				System.out.println(i);
	}
}
