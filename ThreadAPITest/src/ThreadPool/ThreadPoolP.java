package ThreadPool;

public interface ThreadPoolP {
	/**
	 * 
	 * @Title execute
	 * @param runnabel
	 * @Description 提交任务到线程池
	 * @throws
	 */
	void execute(Runnable runnable);
	/**
	 * 
	 * @Title shutdown
	 * @Description 关闭线程池
	 * @throws
	 */
	void shutdown();
	/**
	 * 
	 * @Title getInitSize
	 * @return
	 * @Description  获取线程池初始化大小
	 * @throws
	 */
	int getInitSize();
	/**
	 * 
	 * @Title getMaxSize
	 * @return
	 * @Description 获取线程池最大线程数
	 * @throws
	 */
	int getMaxSize();
	/**
	 * 
	 * @Title getCoreSize
	 * @return
	 * @Description  获取核心线程数
	 * @throws
	 */
	int getCoreSize();
	/**
	 * 
	 * @Title getQueueSize
	 * @return
	 * @Description 获取线程池中缓存队列大小
	 * @throws
	 */
	int getQueueSize();
	/**
	 * 
	 * @Title getActiveCount
	 * @return
	 * @Description 获取线程池中活跃线程数量
	 * @throws
	 */
	int getActiveCount();
	/**
	 * 
	 * @Title isShutdown
	 * @return
	 * @Description 查看线程池是否关闭
	 * @throws
	 */
	boolean isShutdown();
}
