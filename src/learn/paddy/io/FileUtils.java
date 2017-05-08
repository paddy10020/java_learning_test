package learn.paddy.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by 85014 on 2017/4/26.
 */

// 列出File的一些常用操作比如过滤，遍历等操作
public class FileUtils {
	
	
	public static void main (String[] args) throws IOException {
		// 测试列出文件目录
		FileUtils.listDirectory (new File ("E:\\matlab_project"));
	}
	
	
	
	/**
	 * 列出指定目录下（包括子目录）的所有文件
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if (! dir.exists ( )) {
			throw new IllegalArgumentException ("目录:" + dir + "不存在");
		}
		if (!dir.isDirectory ()){
			throw new IllegalArgumentException (dir + "不是目录");
		}
		// 返回的是字符串，不能显示出子目录的所有文件
		/*String[] fileNames = dir.list ();
		for (String str : fileNames) {
			System.out.println (str );
		}*/
		// 返回的是子目录的抽象
		File[] files = dir.listFiles ();
		if (files != null && files.length > 0) {
			for (File each : files) {
				//递归
				if (each.isDirectory ( )) {
					listDirectory (each);
				}else {
					System.out.println (each );
				}
			}
		}
//		for (File each : files) {
//			System.out.println (each );
//		}
	}
}
