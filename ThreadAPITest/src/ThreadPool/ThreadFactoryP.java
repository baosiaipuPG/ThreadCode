package ThreadPool;

@FunctionalInterface
public interface ThreadFactoryP {
	/**
	 * 
	 * @Title createThread
	 * @param runnable
	 * @return
	 * @Description 创建线程
	 * @throws
	 */
	Thread createThread(Runnable runnable);
}
