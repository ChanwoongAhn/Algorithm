import java.util.Scanner;

public class Pro10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String result = "";
		int i = 0;
		int sum = 0;
		while(sc.hasNextInt()) {
			int temp = sc.nextInt();
			
			if(i%2 == 1) {
				sum += temp;
				result += sum +"\n";
				sum = 0;
			}
			else
				sum += temp;
			i++;
			
		}
		System.out.println(result);
	}

}
