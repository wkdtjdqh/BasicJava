package f_oop2.test;

import f_oop2.AccessModifier;

public class AccessTest extends AccessModifier{
	
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
//		System.out.println(am.protectedVar);	//다른 패키지이기 때문에 접근할 수 없다.
//		am.protectedMethod();
		
		AccessTest at = new AccessTest();		//상속받은 경우 개체생성(static이 아니면) 후 접근이 가능하다
		System.out.println(at.protectedVar);
		at.protectedMethod();
		
	}
}
