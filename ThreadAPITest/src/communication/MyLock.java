package communication;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface MyLock {
	/**
	 * 
	 * @Title lock
	 * @throws InterruptedException
	 * @Description 方法永远阻塞，但是该方法时可中断的
	 * @throws
	 */
	void lock() throws InterruptedException;
	/**
	 * 
	 * @Title lock
	 * @param mills
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @Description 方法在规定时间内阻塞 方法可中断
	 * @throws
	 */
	void lock(long mills) throws InterruptedException,TimeoutException,IllegalArgumentException;
	/**
	 * 
	 * @Title unlock
	 * @Description 释放锁
	 * @throws
	 */
	void unlock();
	/**
	 * 
	 * @Title getBlockedThreads
	 * @return
	 * @Description  获取当前阻塞线程
	 * @throws
	 */
	List<Thread> getBlockedThreads();
}
