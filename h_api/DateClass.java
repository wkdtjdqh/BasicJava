package h_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateClass {
	public static void main(String[] args) {
		Date today = new Date();	//현재 날짜
		System.out.println(today);
		
		//날짜 -> 문자열
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.SSS");	//HH:24, hh:12, ss:second, SS:ms(1/1000)
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yy/MM/dd(E) hh:mm:ss a");	//(E):요일, a:오전,오후
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		
		//문자열 -> 날짜
		String str = "1987년 05월 01일";
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy년 MM월 dd일");
		try {	//심플데이터포맷과 일치하지 않을 경우 에러가 발생할 수 있기 때문에 예외처리를 해야한다.
			Date dateStr = sdf5.parse(str);
			
			System.out.println(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//날짜 계산
		Calendar cal = Calendar.getInstance();	//메서드를 호출하면 객체를 하나 생성해서 돌려준다. (싱글톤 패턴)
		/*
		 * 디자인 패턴
		 *  사람들이 클래스를 어떻게 만들면 좋은지 패턴들이 적립이 됨
		 * 싱글톤 패턴
		 *  객체를 하나만 만들어서 사용한다.
		 */
		
		/*
		 public static Calendar getInstance()
	    {
	        Calendar cal = createCalendar(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
	        cal.sharedZone = true;
	        return cal;
	    }
		 */
		
		//Calendar에 날짜를 세팅해야한다.
		cal.setTime(new Date());	//Date객체(기본적으로 현재날짜가 들어있음)를 파라미터로 넣어준다.
		cal.set(2020, 6, 19);	//2020/07/19(월은 0부터 시작)
		System.out.println(cal.getTime());	//getTime() : Date객체를 return
		
		cal.add(Calendar.YEAR, 1);	//1년이 더해진다.
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DAY_OF_MONTH, -3);
		cal.add(Calendar.HOUR, 16);
		cal.add(Calendar.MINUTE, 10);
		cal.add(Calendar.SECOND, -30);
		
		
		System.out.println(sdf3.format(cal.getTime()));	//포맷과 함께 사용이 가능하다.
		
	}
}
