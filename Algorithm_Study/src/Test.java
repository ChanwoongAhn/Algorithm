import java.util.*;
import java.util.Queue;
import java.awt.Point;
import java.io.*;

public class Test {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException 
	/*
	{
		String tmp = br.readLine();
		
		for(int i = 0; i < tmp.length(); i ++) {
			bw.write(tmp.charAt(i) - 64 + " ");
		}
		bw.flush();
		bw.close();
	}
	*/
	/*
	{
		String tmp = br.readLine();
		
		for(int i = 0; i < tmp.length(); i ++) {
			if(tmp.charAt(i) >= 97 && tmp.charAt(i) <= 122) {
				bw.write(tmp.charAt(i) - 32);
			}
			else
				bw.write(tmp.charAt(i));
		}
		bw.flush();
		bw.close();
	}
	*/
	
	{
		int tmp = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tmp; i ++) {
			bw.write("#");
		}
		bw.flush();
		bw.close();
	}

}
