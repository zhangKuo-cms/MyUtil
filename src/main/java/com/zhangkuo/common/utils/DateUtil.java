package com.zhangkuo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author: admin
 * @date: 2019年11月6日 下午2:10:36
 */
public class DateUtil {

	/*
	* 方法1：(5分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		//获取日历类
		Calendar c = Calendar.getInstance();
		
		//传入日期构建日历类
		c.setTime(src);
		
		//设置月初
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	//TODO 实现代码
	}
	/*
	* 方法2：(5分)
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
	//TODO 实现代码
		//让插入的月份加一 日变为月初   秒减一
		//获得日历类
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		
		//让月份加一
		c.add(Calendar.MONTH, 1);
		//让日期变为月初
		Date date = getDateByInitMonth(c.getTime());
		//让月初初始化化日历类
		c.setTime(date);
		//让日期减一秒
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}

	//方法三
	//返回一个在某个时间段的随机日期
	public static Date randomDate(Date minDate ,Date maxDate) {
		//从1970年到mindate的毫秒数
		long l1 = minDate.getTime();
		//从1970年到maxdate的毫秒数
		long l2 = maxDate.getTime();
		
		//获取日历类
		Calendar c = Calendar.getInstance();
		
		//计算随机毫秒数
		long l3 = (long) (Math.random()*(l2-l1+1)+l1);
		c.setTimeInMillis(l3);
		
		return c.getTime();
	}
	/**
	 * 给定时间 随机日期(字符串参数)
	 * @param stratDate  "yyyy-MM-dd"
	 * @param endDate "yyyy-MM-dd"
	 * @return
	 */
	public static Date randomDateString(String stratDate,String endDate) {
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
		long date = 0L;
		try {
			Date d1 = st.parse(stratDate);
			Date d2 = st.parse(endDate);
			date = (long) (Math.random() * (d2.getTime() - d1.getTime() + 1) +d1.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(date);
		
	}
//-----------------------------------------------------------------------------------
public static void main(String[] args) {
		
		Date birth = new Date(100, 0, 6);
		int age = calAge(birth);
		System.out.println("age is " + age);
		
		System.out.println("今天的月初是 " + getMonthStart(new Date()));
		
		
		System.out.println("今天的月末是 " + getMonthEnd(new Date(119, 1, 23)));
		
		
	}
	
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static  int calAge(Date birthday) {
		 
		Calendar cal = Calendar.getInstance();  
		cal.setTime(birthday);
		//获取出生的年月日
		int birthYear = cal.get(Calendar.YEAR);
		int birthMonth = cal.get(Calendar.MONTH);
		int birthDate = cal.get(Calendar.DAY_OF_MONTH);
		
		// 获取今天的年月日
		cal.setTime(new Date());
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDate = cal.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth)
			age--;
		else if (currentMonth==birthMonth){
			if(currentDate<birthDate)
				age--;
		}
		return age;
	}
	
	/**
	 * 判断是否为当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 判断是否为今年
	 * @param date
	 * @return
	 */
	public static boolean isThisYear(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyy");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	/** 
	 *  
	 * 给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * 例如  给定 2017-08-23 13:24:16  返回 2017-08-01 00:00:00 
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		return cal.getTime();
	}
	
	/**
	 * 求月末
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

}
