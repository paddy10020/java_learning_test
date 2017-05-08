package learn.paddy.io;

import java.io.*;

/**
 * Created by 85014 on 2017/4/27.
 */
public class BufferedUtils {
	
	public void copyFileByBuffer (File srcFile, File destFile) throws IOException {
		
		if (!srcFile.exists ())
			throw new IllegalArgumentException ("文件" + srcFile + "不存在");
		if (srcFile.isDirectory ())
			throw new IllegalArgumentException (srcFile + "是目录");
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream (srcFile));
		BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream (destFile));
		int c;
		while ((c = bis.read ( )) != - 1) {
			bos.write (c);
			bos.flush ();// 刷新缓冲区,不能少
		}
		FileReader fw = new FileReader ("");
	}
	
}
