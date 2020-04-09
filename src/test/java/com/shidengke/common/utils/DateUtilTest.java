package com.shidengke.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.zhangkuo.common.utils.DateUtil;

public class DateUtilTest {

	/**
	 * 方法一
	 * @Title: testgetDateByInitMonth 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testgetDateByInitMonth() {

		//获取日历类
		Calendar c = Calendar.getInstance();
		c.set(2001, 8, 5);
		
		//调用方法日期格式
		Date date = DateUtil.getDateByInitMonth(c.getTime());
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		String string = df.format(date);
		System.out.println(string);
	}

	/**
	 * 方法2
	 * @Title: testgetDateByFullMonth 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testgetDateByFullMonth() {

		Calendar c = Calendar.getInstance();
		c.set(2007, 1, 22);
		
		Date date = DateUtil.getDateByFullMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = df.format(date);
		
		System.out.println(string);
	}
	/**
	 * 方法三
	 * @Title: testRandomDate 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testRandomDate() {
		//定义日历类
		Calendar c = Calendar.getInstance();
		c.set(2015, 0, 1);
		
		
		//获取日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (int i = 0; i < 5; i++) {
			Date date = DateUtil.randomDate(c.getTime(), new Date());
			String string = df.format(date);
			System.out.println(string);
		}
	
	}
}
