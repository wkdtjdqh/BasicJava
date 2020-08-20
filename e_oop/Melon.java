package e_oop;

import java.util.Scanner;

public class Melon {
	int volume = 5;
	int num;
	Scanner s = new Scanner(System.in);
	
	int volume_down(){
		return volume--;
	}
	
	int volume_up(){
		return volume++;
	}
	
	void music_num(int number){
		num = number;
		System.out.println(num + "번 노래를 재생합니다.");
	}

	void music_p(){
		System.out.println("노래를 중지합니다.");
		melon_control(Integer.parseInt(s.nextLine()));
	}
	
	void music_s(){
		System.out.println(num + "번 노래를 재생합니다.");
		melon_control(Integer.parseInt(s.nextLine()));
	}
	
	void melon_control(int n){
		if (n == 1) {
			help(n);
			melon_control(Integer.parseInt(s.nextLine()));
		} 
		
		if (n == 8) {
			volume_up();
			System.out.println("volume : " + volume);
			melon_control(Integer.parseInt(s.nextLine()));
		} else if (n == 2) {
			volume_down();
			System.out.println("volume : " + volume);
			melon_control(Integer.parseInt(s.nextLine()));
		} 
		if (n == 6) {
			music_s();
		} else if (n == 5) {
			music_p();
		} else if (n == 7) {
			num--;
			System.out.println(num + "번 노래를 재생합니다.");
			melon_control(Integer.parseInt(s.nextLine()));
		} else if (n == 9) {
			num++;
			System.out.println(num + "번 노래를 재생합니다.");
			melon_control(Integer.parseInt(s.nextLine()));
		}
		
	}
	
	void help(int n){
		System.out.println("-----------------------------------------");
		System.out.println("volume up(8) volume down(2)\n재생(6) 중지(5) 종료(4)");
	}
}
