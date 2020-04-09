package com.shidengke.common.utils;


import org.junit.Test;

import com.zhangkuo.common.utils.RandomUtil;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		int i = RandomUtil.random(1, 3);
		System.err.println(i);
	}

	@Test//获取一到120之间10个随机年龄
	public void testSubRandom() {
		int[] is= RandomUtil.subRandom(1, 120, 10);
		for (int i : is) {
			System.out.println(i);
		}
	}

	@Test
	public void testRandomCharacter() {
		for (int i = 0; i < 4; i++) {
			System.out.println(RandomUtil.randomCharacter());
		}
	}

	@Test
	public void testRandomString() {
		System.out.print(RandomUtil.randomString(6));
	}

}
