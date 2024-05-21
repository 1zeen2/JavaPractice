/*
 *		달력 만들기
 *		1. 년도 / 월 year / month
 *		2. 요일 => year / month / week
 *		3. 출력 = year / month / week
 */
// 멤버 변수 없이 메서드 => 리턴 형, 매개 변수만 사용
package may;

import java.util.*;

public class Fri_17 {
	static String[] strWeek = {"일" ,"월", "화", "수", "목", "금", "토"}; 
	
	//입력 => message를 통해 입력 값을 받는다.
	static int input(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg +" 입력 : ");
		return scan.nextInt();
	}
	static int getWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,  year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);
		
		return cal.get(Calendar.DAY_OF_WEEK);
	}	
	static void result (int year, int month, int day, int week) {
		System.out.printf("%d년 %d월 %d일 %s요일입니다\n", year, month, day, strWeek[week - 1]); 
	}
	
	public static void main(String[] args) {
		int year = input("년도");
		int month = input("월");	
		int day = input("일");
		int week = getWeek(year, month, day);
		
		result(year, month, day, week);
	}

}

/*	1. 입력 값과 날짜를 가져오는 라이브러리가 필요하기 때문에 import jacva.util*; 사용
 *  년도, 월, 일 입력을 받을 메서드 구현. main에서 시작되고 위에서부터 아래로 코드가 진행이 되기 때문에
 *  scanner를 사용할 때 매개 변수를 이용하여 자동으로 년, 월, 일 값이 들어갈 수 있도록 설정.
 *  
 *  2. 달력 기능을 구현한 calendar 라이브러리 호출, Calendar cal = Calendar.getInstance로 호출하고,
 *  year, month, day를 매개 변수를 통해 지정한다. 그리고 Calendar.DAY_OF_WEEK를 통하여 각 값을 요일에 맞게 부여한다.
 *  월은 0월부터 시작이 되기 때문에 변수로 전달된 값에서 -1를 해주어야 알맞게 지정이 된다.
 *  
 *  3. 출력 메서드를 만들어 main에서 불러올 수 있게 값을 만든다. week는 1부터 7까지의 값이 일~토까지 들어있는데
 *  배열을 이용하였기 때문에 원하는 인덱스에 알맞게 들어갈 수 있게 문자열 배열 strWeek에 -1 값을 넣어준다.
 *  
 *  4. 메인 메서드에서는 각 메서드들을 호출한다. 년도 월 일 순으로 값을 입력해 매개 변수에 대입을 하며, 대입한 값을
 *  getWeek 메서드를 통해 대입한 값을 반영해준 후 result 메서드를 통해 호출한다.
 */