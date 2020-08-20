package e_oop;

public class JVM {
	
	int instanceVar;
	static int classVar;
	
	void instanceMethod(){
		System.out.println(instanceVar);
		System.out.println(classVar);
	}
	
	static void classMethod(){
//		System.out.println(instanceVar);	//아직 메모리에 올라가지 않은 상태
		System.out.println(classVar);
	}
	
	public static void main(String[] args) {
		
		/*
		 * JVM(Java Virtual Machine)
		 * - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * - 운영체제 -> JVM -> 자바 프로그램
		 * - 장점 : 운영체제에 상관없이 실행할 수 있다.
		 * - 단점 : 속도가 느리다.
		 * 
		 * JVM 메모리 구조
		 * - Method Area(메서드 영역) : 클래스 멤버가 저장된다.
		 * - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다.
		 * - Heap : 객체가 저장된다.
		 */
		
		//1. 프로그램 실행시 main(), classVar, classMethod()가 MethodArea에 저장된다.
		//2. main()이 호출되어 CallStack에 저장된다. call stack에 main메서드에 있는 지역변수도 함께 저장된다.
		
		System.out.println(classVar);
		//3. System클래스의 out이 MethodArea에 저장된다.
		//4. println()이 호출되어 CallStack에 저장된다.
		//5. println()이 classVar를 출력 후 callStack에서 삭제된다.
		
		classMethod();	//호출, 호출되는 순간 호출 스택에 올라간다. (실행시 메모리에 올라가있기 때문에 호출할 수 있는 것)
		//6. classMethod()가 호출되어 CallStack에 저장된다.
		//7. instanceVar는 메모리에 존재하지 않기 때문에 사용할 수 없다.
		//8. println()이 호출되어 CallStack에 저장된다.
		//9. println()이 classVar를 출력 후 CallStack에서 삭제된다.
		//10. classMethod()의 실행이 종료되어 CallStack에서 삭제된다.
		
		JVM jvm = new JVM();	//객체생성, 생성되면서 Heap에 올라간다.
		//11. JVM객체가 Heap에 저장된다.
		//12. jvm변수가 CallStack에 생성되고, JVM객체의 주소가 저장된다.
		
		System.out.println(jvm.instanceVar);
		//13. println()이 호출되어 CallStack에 저장된다.
		//14. println()이 instanceVar를 출력 후 CallStack에서 삭제된다.
		
		jvm.instanceMethod();
		//15. instanceMethod()가 호출되어 CallStack에 저장된다.
		//16. prtinln()이 호출되어 CallStack에 저장된다.
		//17. println()이 instanceVar를 출력 후 CallStack에서 삭제된다.
		//18. println()이 호출되어 CallStack에 저장된다.
		//19. println()이 ClassVar를 출력 후 CallStack에서 삭제된다.
		//20. instanceMethod()의 실행이 종료되어 CallStack에서 삭제된다.
		
		jvm = null;
		//21. jvm변수에 null이 저장된다. JVM객체를 참조하지 않게된다.
		//22. 어디에서도 주소를 참조하지 않는 JVM객체는 GarbageCollector에 의해 삭제된다.

		//23. main()이 실행이 종료되어 CallStack에서 삭제된다.
		//24. 프로그램이 종료되고  MethodArea의 데이터가 삭제된다.
	}
	
}
