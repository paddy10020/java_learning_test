package learn.paddy.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by 85014 on 2017/4/26.
 */
//用于写入和读取bit
public class TestRaf {
	
	public static void main (String[] args) throws IOException {
		File filePath = new File ("IO_Test");
		if (! filePath.exists ( )) {
			filePath.mkdir ();
		}
		File file = new File (filePath,"raf.data");
		if (! file.exists ( )) {
			file.createNewFile ( );
		}
		RandomAccessFile raf = new RandomAccessFile (file, "rw");
		System.out.println ( raf.getFilePointer () );
		raf.write ('A');    // 一次只写一个字节，但是A有两个字节，写入了A的后8位
		raf.write ('B');
		
		int i = 0x7fffffff;
		// 使用write方法每次只能写一个字节
		raf.write (i>>>24);  // 写入高8位
		raf.write (i >>> 16);
		raf.write (i >>> 8);
		raf.write (i);
		System.out.println (raf.getFilePointer () );
		//上面的操作相当于
//		raf.writeInt (i);
		
		String s = "中";
		byte[] bytes = s.getBytes ("utf-8");
		raf.write (bytes);
		System.out.println (raf.length () );
		
		// 读文件必须把指针移到头部
		raf.seek (0);
		byte[] buf = new byte[(int) raf.length ( )];
		raf.read (buf);
		System.out.println (Arrays.toString (buf) );
		for (byte b : buf) {
			System.out.print (Integer.toHexString (b & 0xff) + " ");
		}
		System.out.println ( );
		String s1 = new String (buf, "utf-8");
		System.out.println (s1 );
		raf.close ();
	}
	
	
}
