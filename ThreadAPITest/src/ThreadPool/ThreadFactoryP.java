package ThreadPool;

@FunctionalInterface
public interface ThreadFactoryP {
	/**
	 * 
	 * @Title createThread
	 * @param runnable
	 * @return
	 * @Description �����߳�
	 * @throws
	 */
	Thread createThread(Runnable runnable);
}
