package i_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * boolean	add(Object obj)	: 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void		add(int index, Object obj)	: 지정된 위치에 객체를 추가한다.
		 * Object	set(int index, Object obj)	: 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * Object	get(int index)	: 지정된 위치의 객체를 반환한다.
		 * int 		size()	: 지정된 객체의 수를 반환한다.
		 * boolean	remove(int index)	: 지정된 위치의 객체를 제거한다.
		 */
		
		ArrayList sample = new ArrayList();
		sample.add("abc");	//파라미터 값이 0번 인덱스에 저장
		sample.add(100);	//값이 들어있는 인덱스의 다음 인덱스에 저장 즉, 1번 인덱스에 저장된다.
		sample.add(new Scanner(System.in));	//값을 집어넣을 때는 아무 타입이나 넣을 수 있어서 좋지만 값을 가져올때는 무슨 값이 들어있는지 알 수가 없음 -> 제네릭이라는 것을 사용
		
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 어렵다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		
//		list.add("add");	Integer가 아닌 다른 데이터타입이 오면 컴파일 에러가 발생한다.
		list.add(20);
		System.out.println(list.add(30));	//잘 저장됐는지 확인하는 return 타입이 있다 (boolean)
		System.out.println(list);	//ArrayList 확인
		
		list.add(1, 40);	//1번 인덱스에 저장, 기존에 있던 값은 한칸씩 밀리게 된다.
		System.out.println(list);
		
//		list.add(7, 50);	//3번 인덱스까지 있는 경우 7번 인덱스에 값을 넣을 경우 예외가 발생하게 된다.
							//java.lang.IndexOutOfBoundsException: Index: 7, Size: 4
		
		Integer before = list.set(2, 50);	//2번 인덱스에 값을 저장하고 기존 값을 반환한다.
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2));
		System.out.println(list);
		
		Integer integer = list.get(2);	//인덱스 값을 지정해 해당 위치에 있는 값을 반환한다.
		System.out.println(integer);
		
//		for (int i = 0; i < list.size(); i++) {	//length가 아니라 size()를 이용해 길이를 받아온다.
//			System.out.println(i + " : " + list.get(i));
//			
//			list.remove(i);	//0번 인덱스가 비워지면서 1번 인덱스에서 부터 앞으로 당겨지며 배열 길이도 줄어들게 된다.
//							//인덱스를 뒤에서부터 지워야 정상적으로 제거가 된다.
//		}
		
		//값을 제거할 때 뒤에서부터 제거해야 한다.
		for(int i = list.size() - 1; 0 <= i; i--){
			System.out.println(i + " : " + list.get(i));
			list.remove(i);
		} System.out.println(list);
		
		//list에 1부터 100까지 랜덤값을 10개 저장해주세요.
		
		for(int i = 0; i < 10; i++) {
			int rand = (int)(Math.random()*100)+1;
			list.add(rand);
		} System.out.println(list);
		
		//list에 저장된 값을 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		} 
		avg = (double)sum / list.size();
		System.out.println("sum : " + sum + "\navg : " + avg);
		
		//list에서 최소값과 최대값을 구해주세요.
		int min = list.get(0), max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= min) {
				min = list.get(i);
			}
			if (list.get(i) >= max) {
				max = list.get(i);
			}
		}
		System.out.println(list);
		System.out.println("min : " + min + "\nmax : " + max);
		
		//list를 오름차순으로 정렬해주세요.
		System.out.println(list);
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.size(); j++) {
//				if (list.get(i) < list.get(j)) {
//					int temp = list.set(i, list.get(j));
//					list.set(j, temp);
//				}
//			}
//		}
//		System.out.println(list);

		//정렬 수정필요
		for (int i = 0; i < list.size(); i++) {
			boolean changed = false;
			for (int j = 0; j < list.size() - i-1; j++) {
				if (list.get(i) < list.get(j)) {
					int temp = list.set(i, list.get(j));
					list.set(j, temp);
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
		System.out.println(list);
		
		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		
		list = new ArrayList<>();
		list2.add(list);
		list.add(40);
		list.add(50);
		
		System.out.println(list2);
		for (int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> li = list2.get(i);
			for(int j = 0; j < li.size(); j++) {
				System.out.print(li.get(j) + "\t");
			}
			System.out.println();
		}
		
		Integer integer2 = list2.get(0).get(1);
		System.out.println(integer2);
	}
}
