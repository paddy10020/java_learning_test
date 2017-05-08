package learn.paddy.io;

import java.io.*;

/**
 * Created by 85014 on 2017/4/26.
 */
public class IOUtil {
	
	public static void main (String[] args) {
	
	}
	
	/**
	 * 读取指定文件内容，按照16进制输入到控制台
	 * @param fileName
	 */
	public static void printHex (String fileName) throws IOException {
		FileInputStream in = new FileInputStream (fileName);
		int b = 0;
		while ((b = in.read ( )) != - 1) {
			System.out.println ( Integer.toHexString (b) + " " );
		}
	}
	
	public static void writeFile(String fileName, String text) throws IOException{
		// append=true是在文件后面添加
		FileOutputStream out = new FileOutputStream (fileName, true);
		
//		FileOutputStream out = new FileOutputStream (fileName);
		
		byte[] buf;
		buf = text.getBytes ();
		out.write (buf, 0, buf.length);
		out.flush ();
		out.close ();
	}
	
	public static void testDataOutputStream (String fileName) throws IOException {
		DataOutputStream out = new DataOutputStream (new FileOutputStream (new File(fileName)));
		out.writeDouble (10.2);
		out.writeInt (20);
		out.flush ();
		out.close ();
		
	}
	
	
}
