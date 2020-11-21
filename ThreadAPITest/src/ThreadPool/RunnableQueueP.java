package ThreadPool;

public interface RunnableQueueP {
	/**
	 * 
	 * @Title offer
	 * @param runnable
	 * @Description 新任务进来时添加到队列中
	 * @throws
	 */
	void offer(Runnable runnable);
	/**
	 * 
	 * @Title task
	 * @return
	 * @Description 取出队列中得任务
	 * @throws
	 */
	Runnable task() throws InterruptedException;
	/**
	 * 
	 * @Title size
	 * @return
	 * @Description 获取任务队列大小
	 * @throws
	 */
	int size();
}
