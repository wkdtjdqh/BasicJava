package e_oop;

public class ClassMaker2 {
	//한줄복사 : Ctrl + Alt + 방향키(위/아래)
	//한줄이동 : Alt + 방향키(위/아래)
	//한줄삭제 : Ctrl + D

	// 초기화 순서 : 명시적 초기화 → 초기화 블럭 → 생성자 
	
	// 인스턴스변수 하나를 선언하고 명시적으로 초기화 해주세요.
	int var = 0;

	// 위에서 선언한 인스턴스변수를 블럭을 사용해 초기화 해주세요.
	{
		var = 1;
	}

	// 위에서 선언한 인스턴스변수를 생성자의 파라미터를 사용해 초기화 해주세요.
	ClassMaker2(int var) {
		this.var = var;
	}

	// ClassMaker2 cm2 = new ClassMaker2(2);

	// 위에서 선언한 인스턴스변수를 생성자를 하나 더 만들어서 초기화 해주세요.
	ClassMaker2() {
		this(2);
	}
}