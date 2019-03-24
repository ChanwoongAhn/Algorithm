import java.util.*;

public class Prob_4261 {
	public static Scanner sc = new Scanner(System.in);
	
	public static String convertalptonum(String word) {
		String tmp = "";
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) >= 97 && word.charAt(i) <= 99)
				tmp += "2";
			else if(word.charAt(i) >= 100 && word.charAt(i) <= 102)
				tmp += "3";
			else if(word.charAt(i) >= 103 && word.charAt(i) <= 105)
				tmp += "4";
			else if(word.charAt(i) >= 106 && word.charAt(i) <= 108)
				tmp += "5";
			else if(word.charAt(i) >= 109 && word.charAt(i) <= 111)
				tmp += "6";
			else if(word.charAt(i) >= 112 && word.charAt(i) <= 115)
				tmp += "7";
			else if(word.charAt(i) >= 116 && word.charAt(i) <= 118)
				tmp += "8";
			else if(word.charAt(i) >= 119 && word.charAt(i) <= 122)
				tmp += "9";
		}
		return tmp;
	}
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		int order_label = 1;
		
		while(testcase-- > 0) {
			String num = sc.next();
			int word_num = sc.nextInt();
			int correct_num = 0;
			
			String [] dic = new String[word_num];
			for(int i = 0; i < word_num; i++)
				dic[i] = sc.next();
			
			for(int i = 0; i < word_num; i++) {
				dic[i] = convertalptonum(dic[i]);
				if(dic[i].equals(num))
					correct_num ++;
			}
			System.out.print("#" +(order_label++) + " ");
			System.out.println(correct_num);
		}
	}
}
