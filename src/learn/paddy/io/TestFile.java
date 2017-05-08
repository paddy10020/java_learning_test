package learn.paddy.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by 85014 on 2017/4/26.
 */
public class TestFile {
	
	public static void main(String[] args){
		// 文件的路径
		String filePath = "C:/Users/85014";
		// 文件的名字
		String fileName = "test.txt";
		File file = new File(filePath, fileName);
//		File file = new File(filePath + "/" + fileName);
		if(!file.exists ()) {
			try {
				// 创建文件
				file.createNewFile ( );
				// 删除文件
				file.delete ();
				// 创建目录
//				file.mkdir ()
//				file.mkdirs ()
			} catch (IOException e) {
				e.printStackTrace ( );
			}
		}
		System.out.println ("is directory " +  file.isDirectory ());
		System.out.println ("is file " +  file.isFile () );
		//file.toString()打印文件的路径
		System.out.println (file );
		System.out.println (file.getAbsolutePath () );
		System.out.println (file.getName () );
		// 打印父目录
		System.out.println (file.getParent () );
		
	}
	
	
}
