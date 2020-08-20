package e_oop;

import java.util.Scanner;

public class Fan {
	Scanner sc = new Scanner(System.in);

	boolean fanRotate;
	String rotate;
	String fanLevel;
	int timer;
	
	final int MAX_TIME = 5;
	final int MIN_TIME = 1;
	
	Fan(){
		fanRotate = false;
		fanLevel = null;
		rotate = "정지";
		timer = 0;
	}
	
	void fanStatus() {
		System.out.println("풍량 : " + fanLevel + "\n회전상태 : " + rotate + "\n예약시간 : " + timer + "시");
	}
	
	void fanPower(int level){
		if (level == 1) {
			fanLevel = "미풍";
		} else if (level == 2) {
			fanLevel = "약풍";
		} else fanLevel = "강풍";
	}
	
	void fanRotation() {
		fanRotate = !fanRotate;
		rotate = fanRotate ? "회전" : "정지";
	}
	
	void fanTimer() {
		System.out.println("------------");
		System.out.println("시간을 설정하세요");
		System.out.println("[1 ~ 5][H]");
		System.out.println("------------");
		timer = Integer.parseInt(sc.nextLine());
		if (timer < 1) {
			System.out.println("잘못된 입력입니다.");
			fanTimer();
		} else if (5 < timer) {
			System.out.println("잘못된 입력입니다.");
			fanTimer();
		}
		
		System.out.println("설정된 시간은 " + timer + "시간 입니다.");
	}
}