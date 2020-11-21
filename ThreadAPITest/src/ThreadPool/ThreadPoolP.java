package ThreadPool;

public interface ThreadPoolP {
	/**
	 * 
	 * @Title execute
	 * @param runnabel
	 * @Description �ύ�����̳߳�
	 * @throws
	 */
	void execute(Runnable runnable);
	/**
	 * 
	 * @Title shutdown
	 * @Description �ر��̳߳�
	 * @throws
	 */
	void shutdown();
	/**
	 * 
	 * @Title getInitSize
	 * @return
	 * @Description  ��ȡ�̳߳س�ʼ����С
	 * @throws
	 */
	int getInitSize();
	/**
	 * 
	 * @Title getMaxSize
	 * @return
	 * @Description ��ȡ�̳߳�����߳���
	 * @throws
	 */
	int getMaxSize();
	/**
	 * 
	 * @Title getCoreSize
	 * @return
	 * @Description  ��ȡ�����߳���
	 * @throws
	 */
	int getCoreSize();
	/**
	 * 
	 * @Title getQueueSize
	 * @return
	 * @Description ��ȡ�̳߳��л�����д�С
	 * @throws
	 */
	int getQueueSize();
	/**
	 * 
	 * @Title getActiveCount
	 * @return
	 * @Description ��ȡ�̳߳��л�Ծ�߳�����
	 * @throws
	 */
	int getActiveCount();
	/**
	 * 
	 * @Title isShutdown
	 * @return
	 * @Description �鿴�̳߳��Ƿ�ر�
	 * @throws
	 */
	boolean isShutdown();
}
