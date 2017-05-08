package learn.paddy.hex;

/**
 * Created by 85014 on 2017/4/26.
 */
import java.util.*;

// 输出32位16进制数
public class TestHexadecima {
	
	public static void main(String[] args) {
		int[] test = new int[10];
		Random random = new Random (100);
		for(int i=0; i<10; i++) {
			test[i] = random.nextInt (100);
		}
		for (int each : test) {
			System.out.print (each + " " );
		}
		System.out.println ( );
		for (int each : test) {
			System.out.print (Integer.toHexString (each & 0xffff) + " " );
		}
	}
}
