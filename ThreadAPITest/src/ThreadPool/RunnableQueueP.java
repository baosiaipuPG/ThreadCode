package ThreadPool;

public interface RunnableQueueP {
	/**
	 * 
	 * @Title offer
	 * @param runnable
	 * @Description ���������ʱ��ӵ�������
	 * @throws
	 */
	void offer(Runnable runnable);
	/**
	 * 
	 * @Title task
	 * @return
	 * @Description ȡ�������е�����
	 * @throws
	 */
	Runnable task() throws InterruptedException;
	/**
	 * 
	 * @Title size
	 * @return
	 * @Description ��ȡ������д�С
	 * @throws
	 */
	int size();
}
