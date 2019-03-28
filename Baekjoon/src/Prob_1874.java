import java.io.*;
import java.util.*;

public class Prob_1874 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Stack<Integer> s = new Stack<Integer>();
	public static int [] arr;
    public static ArrayList<String> arl = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		int max_num = 0;
		boolean flag = true;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i ++) {
			if(arr[i] > max_num) {
				for(int j = max_num + 1; j <= arr[i]; j ++) {
					s.push(j);
					arl.add("+");
				}
				max_num = arr[i];
				s.pop();
				arl.add("-");
			}
			else {
				int tmp = 0;;
				while(!s.isEmpty()) {
					tmp = s.pop();
					arl.add("-");
					if(tmp == arr[i])
						break;
				}
				if(tmp != arr[i] && s.isEmpty()){
					flag = false;
                    break;
                }
			}
		}
		if(flag)
            for(int i = 0; i < arl.size(); i ++)
    			bw.write(arl.get(i) + "\n");
		else
			bw.write("NO");
		bw.flush();
		bw.close();
	}
}
