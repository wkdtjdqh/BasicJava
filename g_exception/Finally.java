package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * finally
		 * - 필요에 따라 try-catch 뒤에 finally를 추할 수 있다.
		 * finally는 예외의 발생여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수 언선;변수선언) {} catch(Exception e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에 선언하면 try 블럭 종료시 자동으로 반환된다.
		 */
		
		FileInputStream fis = null; // 파일 읽기
		
		try {
			fis = new FileInputStream("d:/file.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {	//예외 발생여부와 상관없이 실행을 해야할 때 finally문을 사용한다.
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		//예외 발생 : try -> catch -> finally
		//예외 미발생 : try -> finally
		
		//자동 자원 반환(JDK1.7)
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")) {	//파일 만들기
			String str = "아무내용";
			
			byte[] bytes = str.getBytes();
			
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
