package com.zhangkuo.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 流处理工具类
 * @ClassName: StreamUtil 
 * @Description: TODO
 * @author: admin
 * @date: 2019年11月6日 下午2:11:13
 */
public class StreamUtil {

	/**
	 *  关闭所有的流
	 * @param n
	 * @param streams
	 * @throws IOException
	 */
	public static void closeStream(Closeable ... streams) throws IOException {
		
		for (int i = 0; i < streams.length; i++) {
			streams[i].close();
		}
		
	}
	/*
	* 方法1：批量关闭流，参数能传无限个。(3分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	*/
	public static void closeAll(AutoCloseable ... autoCloseables ){
		if(autoCloseables.length!=0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	//TODO 实现代码
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	*/
	public static String readTextFile(InputStream src){
		//字节输出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		String str ="";
		int x = 0;
		try {
			while((x=src.read(b))!=-1) {
				out.write(b,0,x);	
			}
			//
			 str =out.toString("utf-8");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeAll(out,src);
		return str;
	//TODO 实现代码
	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile){
		try {
			return readTextFile(new FileInputStream(txtFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	//TODO 实现代码
	}
	
	/**
	 * 
	 * @Title: readLineTextFile
	 * @Description: 一行行读取文件并写入list集合
	 * @return
	 * @return: List<String>
	 */
	public static List<String> readLineTextFile(File txtFile) {
		 List<String> list = new ArrayList<String>();
		 BufferedReader bf=null;
		try {
			  bf = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile)));
		   String str="";
		   while((str=bf.readLine())!=null) {
			   list.add(str);
		   }
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeAll(bf);
		}
		
		return list;

	}

}
