package com.shidengke.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.zhangkuo.common.utils.StreamUtil;

public class StreamUtilTest {

	/**
	 * 方法一
	 * @Title: testCloseAll 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testCloseAll() {
		
	}

	/**
	 * 方法二
	 * @Title: testReadTextFileInputStream 
	 * @Description: TODO
	 * @return: void
	 * @throws Exception 
	 */
	@Test
	public void testReadTextFileInputStream() {

		try {
		String string = StreamUtil.readTextFile(new FileInputStream("E:/test.txt"));
	
		System.out.println(string);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 方法三
	 * @Title: testReadTextFileFile 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testReadTextFileFile() {
		String string = StreamUtil.readTextFile(new File("E:/test.txt"));
		System.out.println(string);
	}

}
