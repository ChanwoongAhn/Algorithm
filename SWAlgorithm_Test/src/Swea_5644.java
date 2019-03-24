import java.util.*;
import java.util.Queue;

public class Swea_5644 {
	public static Scanner sc = new Scanner(System.in);
	public static Queue <Integer> a = new LinkedList<Integer>();
	public static Queue <Integer> b = new LinkedList<Integer>();
	public static String [][] arr = new String[10][10];
	
	public static void makearr(String [][] arr, int n) {
		int [][] temp = new int[n][4];
		
		for(int i = 0; i < 10; i ++)
			for(int j = 0; j < 10; j ++)
				arr[i][j] = "0";
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < 4; j ++)
				temp[i][j] = sc.nextInt();
		
		for(int i = 0; i < n; i ++) {
			int y = temp[i][0] - 1;
			int x = temp[i][1] - 1;
			int c = temp[i][2];
			int p = temp[i][3];
			int w = (x-c) >= 0 ? (x-c) : 0;
			for(int j = (x-c) >= 0 ? (x-c) : 0; j <= ((x+c) >= 10 ? 9 : x+c); j ++)
				for(int k = (y-c) >= 0 ? (y-c) : 0; k <= ((y+c) >= 10 ? 9 : y+c); k ++) {
					if((Math.abs(x-j) + Math.abs(y-k)) <= c) {
						if(!arr[j][k].equals("0"))
							arr[j][k] = arr[j][k] + "," + p;
						else
							arr[j][k] = "" + p;
					}
				}
			
		}
	}
	public static void moveposition(Queue<Integer> q, int x, int y) {	
		int tmp = q.poll();
		System.out.println(tmp);
		if(tmp == 1)
			y = y - 1;
		else if(tmp == 2)
			x = x + 1;
		else if(tmp == 3)
			y = y + 1;
		else if(tmp == 4)
			x = x - 1;
	}
	public static int getresult(int m, int n) {
		int sumA = 0;
		int sumB = 0;
		int A_x = 0;
		int A_y = 0;
		int B_x = 9;
		int B_y = 9;
		int step = 1;
		
		sumA += Integer.parseInt(arr[A_x][A_y]);
		sumB += Integer.parseInt(arr[B_x][B_y]);
		
		while(m-- > 0) {
			int temp = a.poll();
			
			if(temp == 1)
				A_x = A_x - 1;
			else if(temp == 2)
				A_y = A_y + 1;
			else if(temp == 3)
				A_x = A_x + 1;
			else if(temp == 4)
				A_y = A_y - 1;
			
			temp = b.poll();
			
			if(temp == 1)
				B_x = B_x - 1;
			else if(temp == 2)
				B_y = B_y + 1;
			else if(temp == 3)
				B_x = B_x + 1;
			else if(temp == 4)
				B_y = B_y - 1;

			String a_amount = arr[A_x][A_y];
			String b_amount = arr[B_x][B_y];
			System.out.println(A_x + " " + A_y + " " + a_amount);
			System.out.println(B_x + " " + B_y + " " + b_amount);
			if(a_amount.equals(b_amount) && a_amount.length() <= 3) {
				if(a_amount.length() <= 3) {
					sumA += Integer.parseInt(a_amount)/2;
					sumB += Integer.parseInt(b_amount)/2;
				}
				else {	// 100, 70ÀÇ °æ¿ì
					int numofcomma = 0;
					int j = 0;
					
					for(int i = 0; i < a_amount.length(); i ++) {
						if(a_amount.charAt(i) == ',')
							numofcomma ++;
					}
					String [] numarr = new String[numofcomma+1];
					
					for(int i = 0; i < a_amount.length(); i ++) {
						while(a_amount.charAt(i) != ',')
							numarr[j] += a_amount.charAt(i);
						j++;
					}
					
					for(int i = 0; i < numarr.length; i ++) {
						for(int k = i + 1; k < numarr.length; k ++) {
							if(Integer.parseInt(numarr[i]) < Integer.parseInt(numarr[k])) {
								String tmp = numarr[i];
								numarr[i] = numarr[k];
								numarr[k] = tmp;
							}
						}
					}
					sumA += Integer.parseInt(numarr[0]);
					sumB += Integer.parseInt(numarr[1]);
				}
			}
			else {
				if(a_amount.length() <= 3 && b_amount.length() <= 3) {
					sumA += Integer.parseInt(a_amount);
					sumB += Integer.parseInt(b_amount);
				}
				else {
					if(a_amount.length() > 3 && b_amount.length() > 3) {
						int numofcomma_a = 0;
						int j_a = 0;
						
						for(int i = 0; i < a_amount.length(); i ++) {
							if(a_amount.charAt(i) == ',')
								numofcomma_a ++;
						}
						String [] numarr_a = new String[numofcomma_a+1];
						
						for(int i = 0; i < a_amount.length(); i ++) {
							if(a_amount.charAt(i) == ',')
								j_a ++;
							else {
								if(numarr_a[j_a] == null)
									numarr_a[j_a] = "" + a_amount.charAt(i);
								else
									numarr_a[j_a] += "" + a_amount.charAt(i);
							}
						}
						for(int i = 0; i < numarr_a.length; i ++) {
							for(int k = i + 1; k < numarr_a.length - 1; k ++) {
								if(Integer.parseInt(numarr_a[i]) < Integer.parseInt(numarr_a[k])) {
									String tmp = numarr_a[i];
									numarr_a[i] = numarr_a[k];
									numarr_a[k] = tmp;
								}
							}
						}
						int numofcomma_b = 0;
						int j_b = 0;
						
						for(int i = 0; i < b_amount.length(); i ++) {
							if(b_amount.charAt(i) == ',')
								numofcomma_b ++;
						}
						String [] numarr_b = new String[numofcomma_b+1];
						
						for(int i = 0; i < b_amount.length(); i ++) {
							if(b_amount.charAt(i) == ',')
								j_b ++;
							else {
								if(numarr_b[j_b] == null)
									numarr_b[j_b] = "" + b_amount.charAt(i);
								else
									numarr_b[j_b] += "" + b_amount.charAt(i);
							}
						}
						for(int i = 0; i < numarr_b.length; i ++) {
							for(int k = i + 1; k < numarr_b.length - 1; k ++) {
								if(Integer.parseInt(numarr_b[i]) < Integer.parseInt(numarr_b[k])) {
									String tmp = numarr_b[i];
									numarr_b[i] = numarr_b[k];
									numarr_b[k] = tmp;
								}
							}
						}
						System.out.println(numarr_a[0]);
						System.out.println(numarr_b[0]);
						//
						sumA += Integer.parseInt(numarr_a[0]);
						for(int i = 0; i < numarr_b.length; i ++)
							if(!numarr_b[i].equals(numarr_a[0])) {
								sumB += Integer.parseInt(numarr_b[i]);
								break;
							}
					}
					else if(a_amount.length() > 3) {
						int numofcomma = 0;
						int j = 0;
						
						for(int i = 0; i < a_amount.length(); i ++) {
							if(a_amount.charAt(i) == ',')
								numofcomma ++;
						}
						String [] numarr = new String[numofcomma+1];
						
						for(int i = 0; i < a_amount.length(); i ++) {
							if(a_amount.charAt(i) == ',')
								j ++;
							else {
								if(numarr[j] == null)
									numarr[j] = "" + a_amount.charAt(i);
								else
									numarr[j] += "" + a_amount.charAt(i);
							}
						}
						for(int i = 0; i < numarr.length; i ++) {
							for(int k = i + 1; k < numarr.length - 1; k ++) {
								if(Integer.parseInt(numarr[i]) < Integer.parseInt(numarr[k])) {
									String tmp = numarr[i];
									numarr[i] = numarr[k];
									numarr[k] = tmp;
								}
							}
						}
						System.out.println(numarr[0]);
						System.out.println(numarr[1]);
						for(int i = 0; i < numarr.length; i ++)
							if(!numarr[i].equals(b_amount)) {
								sumA += Integer.parseInt(numarr[i]);
								sumB += Integer.parseInt(b_amount);
								break;
							}	
					}
					else {
						int numofcomma = 0;
						int j = 0;
						
						for(int i = 0; i < b_amount.length(); i ++) {
							if(b_amount.charAt(i) == ',')
								numofcomma ++;
						}
						String [] numarr = new String[numofcomma+1];
						
						for(int i = 0; i < b_amount.length(); i ++) {
							if(b_amount.charAt(i) == ',')
								j ++;
							else {
								if(numarr[j] == null)
									numarr[j] = "" + b_amount.charAt(i);
								else
									numarr[j] += "" + b_amount.charAt(i);
							}
						}
						for(int i = 0; i < numarr.length; i ++) {
							for(int k = i + 1; k < numarr.length - 1; k ++) {
								if(Integer.parseInt(numarr[i]) < Integer.parseInt(numarr[k])) {
									String tmp = numarr[i];
									numarr[i] = numarr[k];
									numarr[k] = tmp;
								}
							}
						}
						System.out.println(numarr[0]);
						System.out.println(numarr[1]);
						for(int i = 0; i < numarr.length; i ++)
							if(!numarr[i].equals(b_amount)) {
								sumA += Integer.parseInt(a_amount);
								sumB += Integer.parseInt(numarr[i]);
								break;
							}	
					}
				}
			}
			System.out.println("Step : " + (step++));
			System.out.println("sumA : " + sumA + "sumB : " +sumB);
		}
		return sumA + sumB;
	}
	public static void printarr() {
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 10; j ++) {
				System.out.printf("%15s", arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase -- > 0) {
			int m = sc.nextInt();
			int numofcharger = sc.nextInt();
			
			for(int i = 0; i < m; i ++)
				a.add(sc.nextInt());
			for(int i = 0; i < m; i ++)
				b.add(sc.nextInt());
			
			makearr(arr, numofcharger);
			printarr();
			System.out.println("#" + (order_label++) + " " +getresult(m, numofcharger));
		}
	}

}
