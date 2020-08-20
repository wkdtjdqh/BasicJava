package h_api;

import java.util.ArrayList;
import java.util.Arrays;

public class WrapperClass {
	public static void main(String[] args) {
		/*
		 * Wrapper Class : 기본형 타입을 객체로 사용해야 할 때 대신 사용하는 클래스
		 * 	 (type)		: (Class)
		 * - boolean	: Boolean
		 * - char		: Character
		 * - byte		: Byte
		 * - short		: Short
		 * - int		: Inteager
		 * - long		: Long
		 * - float		: Float
		 * - double		: Double
		 */
		
		Integer iw = new Integer(20);
		
		System.out.println(Integer.TYPE + " / " + Integer.SIZE + "bit");
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		int parseInt = Integer.parseInt("20");
		
		//컬렉션
		ArrayList<Integer> list = new ArrayList<>();	//ArrayList에 저장할 타입을 지정 <Inteager> (객체) 기본형타입을 객체로 할 수 없어 Wrapper Class를 사용해 파라미터로 지정해준다.
		list.add(new Integer(10));	//번거롭다.
		list.add(20);	//생략하고 기본형 타입을 사용할 수 있다.(Wrapper Class와 오토박싱이 이루어짐) 오토박싱 : 기본형타입이 Wrapper Class로 자동 변환
		
		Integer integer = list.get(0);	//파라미터에 인덱스를 넣어줘서 해당 인덱스에 값을 받아온다.
		int i = list.get(1);	//기본형타입에도 저장이 가능하다.(파라미터에는 인덱스번호) 언박싱 : Wrapper Class가 기본형타입으로 자동 변환
		System.out.println(list);
		System.out.println(i);
				
	}
}
