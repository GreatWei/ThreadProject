
public class ValatileTest {

	//保证的了的所有线程动态可见，保证不了所有线程操作的原子性
	public static volatile int race = 0;

	public static void increase() {
		race++;
	}

	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		// 等待所有的线程加载结束
		while (Thread.activeCount() > 1) {
			Thread.yield();
			System.out.println(race);
		}
	}

}
