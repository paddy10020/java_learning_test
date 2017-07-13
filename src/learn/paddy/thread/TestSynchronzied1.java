package learn.paddy.thread;

/**
 * Created by 85014 on 2017/5/8.
 */
public class TestSynchronzied1  {
	
	// synchronized 程序块
	public void test1(){
		synchronized (this){
			for (int i=0; i<5; i++) {
				System.out.println (Thread.currentThread ().getName () + ":" + i );
			}
		}
	}
	
	// synchronized 方法
	public synchronized void test2(){
		for (int i=0; i<5; i++) {
			System.out.println (Thread.currentThread ().getName () + ":" + i );
		}
	}
	
	public void test3(){
		for (int i=0; i<5; i++) {
			System.out.println (Thread.currentThread ().getName () + ":" + i );
		}
	}
	
	public static void main (String[] args) {
		TestSynchronzied1 test = new TestSynchronzied1 ( );
		Thread t1 = new Thread (new Runnable ( ) {
			@Override
			public void run () {
				test.test1 ();
				try {
					Thread.sleep (50);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}, "A");
		
		Thread t2 = new Thread (new Runnable ( ) {
			@Override
			public void run () {
				test.test2 ();
				try {
					Thread.sleep (50);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}, "B");
		
		Thread t3 = new Thread (new Runnable ( ) {
			@Override
			public void run () {
				test.test3 ();
				try {
					Thread.sleep (10);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}, "C");
		t1.start ();
		t2.start ();
		t3.start ();
	}
	
}
