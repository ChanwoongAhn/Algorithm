import java.io.*;

public class Prob_1193 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int direction1[] = {1, -1};
		int direction2[] = {-1, 1};
		int position[] = {0, 1};
		int current_direction[];
		current_direction = direction1;
		int i = 1;
		
		if(n == 1) {
			bw.write(1 +"/" + 1);
			bw.flush();
			bw.close();
		}
		else {
			n -= 1;
			while(n > i++) {
				int next_position[] = new int[2];
				next_position[0] = position[0] + current_direction[0];
				next_position[1] = position[1] + current_direction[1];
				
				if(next_position[0] < 0) {
					next_position[0] = position[0];
					next_position[1] = position[1] + 1;
					current_direction = direction1;
				}
				else if(next_position[1] < 0) {
					next_position[0] = position[0] + 1;
					next_position[1] = position[1];
					current_direction = direction2;
				}
				
				position[0] = next_position[0];
				position[1] = next_position[1];
			}
			bw.write((position[0] + 1) + "/" +(position[1] + 1));
			bw.flush();
			bw.close();
		}
	}
}
