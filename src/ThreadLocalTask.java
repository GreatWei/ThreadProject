import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadLocalTask {

	public static final int GEN_COUNT = 10000000;
	public static final int THREAD_COUNT = 4;
	public static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
	public static Random rnd = new Random(132);

	public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random(123);
		}
	};

	public static class RndTask implements Callable<Long> {

		private int mode = 0;

		public RndTask(int mdoe) {
			// TODO Auto-generated constructor stub
			this.mode = mdoe;
		}

		public Random getRandom() {
			if (mode == 0) {
				return rnd;
			} else if (mode == 1) {
				return tRnd.get();
			} else {
				return null;
			}
		}

		@Override
		public Long call() throws Exception {
			// TODO Auto-generated method stub
			long b = System.currentTimeMillis();
			for (int i = 0; i < GEN_COUNT; i++) {
				getRandom().nextInt();
			}
			long e = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + "spend" + (e - b) + "ms");
			return e - b;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Future<Long>[] futs = new Future[THREAD_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			futs[i] = exe.submit(new RndTask(0));
		}
		long totalTime = 0;

		for (int i = 0; i < THREAD_COUNT; i++) {
			totalTime += futs[i].get();
		}

		System.out.println("多线程访问一个Random实例：" + totalTime + " ms");

		for (int i = 0; i < THREAD_COUNT; i++) {
			futs[i] = exe.submit(new RndTask(1));
		}
		totalTime = 0;
		for (int i = 0; i < THREAD_COUNT; i++) {
			totalTime += futs[i].get();
		}
		System.out.println("使用threadlocal包装random实例：" + totalTime + " ms");
		exe.shutdown();
	}

}
