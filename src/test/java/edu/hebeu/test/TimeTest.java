package edu.hebeu.test;

import java.util.Date;

import edu.hebeu.util.MTimeUtil;

public class TimeTest {

	public static void main(String[] args) {
		/*for(int i=0;i<=24;i++){
			System.out.println(MTimeUtil.stringTimeParse(i+":00:00").getTime());
		}*/
		
		System.out.println(MTimeUtil.stringTimeParse("11:59:58").getTime());
		System.out.println(MTimeUtil.stringTimeParse("11:59:59").getTime());
		Date date1 = MTimeUtil.stringTimeParse("11:59:58");
		Date date2 = MTimeUtil.stringTimeParse("11:59:59");
		System.out.println(date2.after(date1));
		
		/*System.out.println(MTimeUtil.stringTimeParse("11:59:59").getTime());
		System.out.println(MTimeUtil.stringTimeParse("12:00:00").getTime());
		Date date1 = MTimeUtil.stringTimeParse("11:59:59");
		Date date2 = MTimeUtil.stringTimeParse("12:00:00");
		System.out.println(date1.before(date2));*/
		
		/*System.out.println(MTimeUtil.stringTimeParse("12:00:01").getTime());
		System.out.println(MTimeUtil.stringTimeParse("12:00:00").getTime());
		Date date1 = MTimeUtil.stringTimeParse("12:00:01");
		Date date2 = MTimeUtil.stringTimeParse("12:00:00");
		System.out.println(date1.after(date2));*/
	}
}
