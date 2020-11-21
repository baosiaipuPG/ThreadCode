package communication;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface MyLock {
	/**
	 * 
	 * @Title lock
	 * @throws InterruptedException
	 * @Description ������Զ���������Ǹ÷���ʱ���жϵ�
	 * @throws
	 */
	void lock() throws InterruptedException;
	/**
	 * 
	 * @Title lock
	 * @param mills
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @Description �����ڹ涨ʱ�������� �������ж�
	 * @throws
	 */
	void lock(long mills) throws InterruptedException,TimeoutException,IllegalArgumentException;
	/**
	 * 
	 * @Title unlock
	 * @Description �ͷ���
	 * @throws
	 */
	void unlock();
	/**
	 * 
	 * @Title getBlockedThreads
	 * @return
	 * @Description  ��ȡ��ǰ�����߳�
	 * @throws
	 */
	List<Thread> getBlockedThreads();
}
