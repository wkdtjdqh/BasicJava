package g_exception;

import java.io.IOException;

public class ThrowException {

	static String str = null;
	
	public static void main(String[] args) {
		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 * - throw 예약어와 예외 클래스의 객체로 예외를 고의로 발생시킬 수 있다.
		 */
		
//		IOException ioe = new IOException();
//		
//		try {
//			throw ioe;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		throw new NullPointerException();
		
//		System.out.println("문장");
		
//		System.out.println(str.equals("abc"));
		
		int[] a = new int[10];
		
		for (int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
}
