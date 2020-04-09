package com.shidengke.common.utils;

import java.io.File;

import org.junit.Test;

import com.zhangkuo.common.utils.FileUtil;

public class FileUtilTest {

	/**
	 * 方法一
	 * @Title: testGetExtendName 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testGetExtendName() {

		//定义一个文件
		String file = "abc.abc";
		//获取方法一
		String name = FileUtil.getExtendName(file);
		System.out.println(name);
	}

	/**
	   * 方法二 
	 * @Title: testGetTempDirectory 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testGetTempDirectory() {
		File file = FileUtil.getTempDirectory();
		System.out.println(file);
	}

	/**
	 * 方法三
	 * @Title: testGetUserDirectory 
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testGetUserDirectory() {
		File file = FileUtil.getUserDirectory();
		System.out.println(file);
	}

}
