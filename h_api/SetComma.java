package h_api;

import java.util.Arrays;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1,000,000
		String input = ScanUtil.nextLine();
		String e = "";
		int cnt = 0;
		
		for (int i = input.length()-1; 0 <= i; i--) {
			e += input.charAt(i);
			cnt++;
			if (cnt % 3 == 0 && cnt != input.length()) {
				e += ",";
			}
		}
		
		input = "";
		for (int i = e.length()-1; 0 <= i; i--) {
			input += e.charAt(i);
		}
		System.out.println(input);
		
	}
		
	/*
	 	String input = ScanUtil.nextLine();
		String e = "";
		int cnt = 0;
		
		for (int i = input.length()-1; 0 <= i; i--) {
			e = input.charAt(i) + e;
			cnt++;
			if (cnt % 3 == 0 && cnt != input.length()) {
				e = "," + e;
			}
		}
	 */
}
