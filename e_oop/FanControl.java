package e_oop;

import java.util.Scanner;;

public class FanControl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fan fan = new Fan();
		
		while(true) {
			
			System.out.println(" ㅡㅡㅡㅡㅡ\n| 선풍기  |\nㅡㅡㅡㅡㅡ");
			System.out.println("|정지(1)|\n|미풍(2)|\n|약풍(3)|\n|강풍(4)|\n"
					+ "|회전(5)|\n|시간(6)|");
			System.out.println(" ㅡㅡㅡㅡㅡ");
			
			int fanControl = Integer.parseInt(sc.nextLine());
			
			switch (fanControl) {
			case 1: 
				System.out.println("정지");
				System.exit(0);
				break;
			case 2: 
				fan.fanPower(1);
				break;
			case 3: 
				fan.fanPower(2);
				break;
			case 4: 
				fan.fanPower(3);
				break;
			case 5: 
				fan.fanRotation();
				break;
			case 6: 
				fan.fanTimer();
				break;
			}
			
			fan.fanStatus();
		}
	}
}
