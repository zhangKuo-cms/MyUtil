package com.zhangkuo.common.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串	
 * @ClassName: StringUtil 
 * @Description: TODO
 * @author: admin
 * @date: 2019年11月8日 上午8:39:56
 */
public class StringUtil {

	/**
	 * 校验传入的是否为url
	 * @Title: hasLength 
	 * @Description: TODO
	 * @param src
	 * @return
	 * @return: boolean
	 */
	
	public static boolean isHttpUrl(String param) {
		URL url;
		
		try {
		url = new URL(param);
		InputStream in = url.openStream();
		return true;
		} catch (Exception e1) {
			System.out.println("连接打不开");
			url = null;
		}
		return false;
		
	}
	
/*	public static boolean isHttpUrl(String param) {
		   URL url;
		   try {
			url = new URL(param);
			InputStream in = url.openStream();
			return true;
		} catch (Exception e) {
			System.out.println("链接打不开");
			url = null;
		}
		   return false;
	}*/
	// 方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 (5分)
		public static boolean hasLength(String src) {
			return null != src && src.length() > 0;

		}

		// 产生随机中文 包含繁体
		public static String randomSimpleChinese() {

			Random r = new Random();
			// 19968:中文第一个汉子对应的数字 40869 中文的最后一个汉子对应的数字
			return (char) (r.nextInt(40869 - 19968 + 1) + 19968) + "";

		}

		// 随机返回一个汉字
		public static String randomChineseString() {
			String str = null;
			int highPos, lowPos;
			Random random = new Random();
			highPos = (176 + Math.abs(random.nextInt(39)));// 区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
			random = new Random();
			lowPos = 161 + Math.abs(random.nextInt(94));// 位码，0xA0打头，范围第1~94列
			byte[] bArr = new byte[2];

			bArr[0] = (new Integer(highPos)).byteValue();
			bArr[1] = (new Integer(lowPos)).byteValue();
			try {
				str = new String(bArr, "GB2312"); // 区位码组合成汉字
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return str;
		}

		// 方法3：返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体)范围内，例如“中呀被”(5分)
		public static String randomChineseString(int length) {
			
			String str="";
			for(int i =0;i<length;i++) {
				str +=randomChineseString();
			}

			return str;
		}

		// 方法4：返回中文姓名，必须以真实姓开头，百家姓在“六、附百家姓”里，名使用1-2个随机汉字(8分)，
		//内部调用randomChineseString()方法(3分)。返回示例：“刘呀被”、“欧阳及为”
		public static String generateChineseName() {
			 String[] surname = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
		              "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云",
		              "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍",
		              "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时",
		              "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪",
		              "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项",
		              "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛",
		              "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢",
		              "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石",
		              "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "于", "惠", "甄", "曲", "家", "封", "芮",
		              "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯",
		              "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符",
		              "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂",
		              "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭",
		              "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈",
		              "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容",
		              "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广",
		              "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾",
		              "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆",
		              "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉", "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归",
		              "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "篁", "年", "爱",
		              "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",
		              "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦",
		              "召", "仪", "风", "介", "巨", "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端",
		              "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾", "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛",
		              "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕",
		              "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇", "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西",
		              "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘", "左丘", "东门", "西门", "南宫", "第五",
		              "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门", "毋丘", "贺兰", "綦毋", "屋庐", "独孤",
		              "南郭", "北宫", "王孙" };
		     //随机获取姓氏
		    String firstname =surname[RandomUtil.random(0, surname.length -1)];
		    
			//名字
		    String lastname =randomChineseString(RandomUtil.random(1, 2));
			return firstname +lastname;
		}

//-*----------------------------------------------------------------------------

		public static String generateChineseSex() {
			 String[] surname = {"男","女"};
			 String firstname =surname[RandomUtil.random(0,1)];
			 return firstname ;
		}
		
		/**
		 *  
		 * @param str
		 * @return  
		 */
		public static  boolean isEmpty(String str) {
			
			return (null==str||"".equals(str.trim()));
		}
		
		
		/**
		 * 是否有值
		判断源字符串是否有值，空引号和空格也算没值
		 * @param str
		 * @return
		 */
		public static boolean hasText1(String str) {
			
			// 以下两种写法都对
			return !(null ==str || "".equals(str.trim()));
//			return (null !=str && !"".equals(str.trim()));
		}
		/**
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isPhone(String str) {
			String pattern = "^(136|135|137)\\d{8}$";
			return str.matches(pattern);
		}
		
		/**
		 *  
		 * @param str
		 * @return
		 */
		public static boolean isEmail(String str) {
			
			String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
			Pattern compile = Pattern.compile(pattern);
			Matcher matcher = compile.matcher(str);
			return matcher.matches();
		}
		
		/**
		 * 验证全为字母
		 * @param str
		 * @return
		 */
		public static boolean isLetter(String str) {
			String pattern = "^[a-zA-Z]+$";
			return str.matches(pattern);
		}
		
		/**
		 * 
		 * 获取n位随机英文字符串
		 * @param n
		 * @return
		 */
		public String randomLetterStr(int n) {
			
			if(n<=0)
				return "";
			Random random = new Random();
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				char letter = (char)('A' + random.nextInt(26));
				sb.append(letter);
			}		
			return sb.toString();
		}
		
		/**
		 * 获取n位随机英文和数字字符串
		 * @param n
		 * @return
		 */
		public String randomStr(int n) {
			
			char chars[]= {'0','1','2','3','4','5','6','7','8','9',
					'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
			
			// 定义个随机对象
			Random random = new Random();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<n;i++) {
				// 随机得到一个下标，根据下标从数组当中获取值，拼接到字符串上
				
				// 随机获取一个下标
				int index = random.nextInt(chars.length);
				char c = chars[index];
				sb.append(c);//向后拼接
				
				/*sb.append( chars[random.nextInt(chars.length)]
						);*/
				
			}
			return sb.toString();
			
		}
		
		//获取n个随机中文字符串
		public static String getRandonCnStr(int n) {
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append(getOneCn());
			}
			return sb.toString();
			
		} 
		
		/**
		 * 随机获取一个中文字符
		 * @return
		 */
		private static String getOneCn(){
			
			String str = "";
	        int hightPos; //
	        int lowPos;
	        Random random = new Random();

	        hightPos = (176 + Math.abs(random.nextInt(39)));
	        lowPos = (161 + Math.abs(random.nextInt(93)));

	        byte[] b = new byte[2];
	        b[0] = (Integer.valueOf(hightPos)).byteValue();
	        b[1] = (Integer.valueOf(lowPos)).byteValue();

	        try {
	            str = new String(b, "GBK");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("错误");
	        }

	        return str;
		}
		
		/*
		* 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
		* 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
		*/
		public static String getPlaceholderValue(String src, String regex){
			//TODO 实现代码
	        Pattern pattern = Pattern.compile(regex);// 匹配的模式  
	        Matcher m = pattern.matcher(src);  
	        boolean find = m.find();
	        if(find) {
	        	String group = m.group(0);
	        	 return group.substring(1,group.lastIndexOf('.'));
	        }
	        return "";
		}
		
		//测试工具包中isNumber()，
		/**
		 * 
		 * @param src
		 * @return
		 */
		public static boolean isNumber(String src) {
			//String regix="[0-9]{1,}(\\.?|[0-9]*)";
			String regix="[0-9]{1,}\\.?[0-9]*";
			return src.matches(regix);
			
			
		}
		
		public static boolean isUrl(String str) {
			 //转换为小写
	        str = str.toLowerCase();
	        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
	                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
	               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184  
	                 + "|" // 允许IP和DOMAIN（域名）
	                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
	                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
	                + "[a-z]{2,6})" // first level domain- .com or .museum  
	                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
	                + "((/?)|" // a slash isn't required if there is no file name  
	                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
	        return  str.matches(regex);
		}
		
		/**
		 * 测试工具包中hasText()，该方法是过滤String参数空格后判断是否有值，
		 * 如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法
		 * @param src
		 * @return
		 */
		public static boolean hasText(String src) {
			String string = src.replaceAll("\\s", "");
			return (!"".equals(string));
		}
		
		/*
		* 方法：生成唯一标签名，处理步骤：
		* 1、全部变成小写；
		* 2、清空两边的空格，把中间所有的空格替换成“-”；
		* 3、使用URLEncoder.encode()编码
		* 最后返回处理的结果。
		* 举例“Spring MVC”处理后为“spring-mvc”，“Spring Mvc”处理后也为“spring-mvc”
		*/
		public static String toUniqueTerm(String term) throws UnsupportedEncodingException{
		//TODO 实现代码
			term=term.toLowerCase();	// 1、全部变成小写；
			term=term.trim();//清空两边的空格，
			term = term.replaceAll(" ", "-");//把中间所有的空格替换成“-”；
			return URLEncoder.encode(term,"UTF-8");//、使用URLEncoder.encode()编码
			
		}
		
		
		/*方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
		 * @ContextConfiguration("classpath:spring.xml")
		*@RunWith(SpringRunner.class)
		* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
		* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。*/
		public static String toHtml1(String src){
			String[] strings = src.split("\\\n");
			StringBuilder sb = new StringBuilder();
			for (String string : strings) {
				sb.append("<p>").append(string).append("</p>");
			}
			return sb.toString();
		}
		
		
		/**
		 * 检测含有\n\r 转换成\n
		 * \r 转换<br>
		 * @param str
		 * @return
		 */
		public static String toHtml(String str) {
			String replaceAll = str.replaceAll("\\\n\r", "\n");
			String replaceAll2 = replaceAll.replaceAll("\\\r", "<br/>");
			/* System.out.println(replaceAll2); */
			String[] split = replaceAll2.split("\\\n");
			StringBuilder sb = new StringBuilder();
			for (String string : split) {
				sb.append("<p>").append(string).append("</p>\n");
			}
			return sb.toString();	
		}
	

		
}
