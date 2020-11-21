package communication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class MyBooleanLock implements MyLock {
	//当前拥有锁的线程
	private Thread currentThread;
	//是否被获取锁
	private boolean locked = false;
	//储存那些获取锁进入阻塞的线程
	private final List<Thread> blocked = new ArrayList<Thread>();
	
	@Override
	public void lock() throws InterruptedException {
		synchronized (this) {
			while(locked) {
				blocked.add(currentThread);
				this.wait();
			}
			blocked.remove(currentThread);
			this.locked = true;
			this.currentThread = Thread.currentThread();
		}
	}

	@Override
	public void lock(long mills) throws InterruptedException, TimeoutException,IllegalArgumentException {
		synchronized (this) {
			if(mills<=0) {
				 throw new IllegalArgumentException("mills 必须大于0");
			}else {
				long remain = mills;
				long endmain = System.currentTimeMillis()+remain;
				while(locked) {
					if(remain<=0) {
						throw new TimeoutException("线程"+Thread.currentThread().getName()+"时间超时");
					}
					if(!blocked.contains(currentThread)) {
						blocked.add(currentThread);
					}
					this.wait(remain);
					remain = endmain - System.currentTimeMillis();
				}
				blocked.remove(currentThread);
				this.locked=true;
				this.currentThread=Thread.currentThread();
			}
			
		}
	}

	@Override
	public void unlock() {
		synchronized (this) {
			if(currentThread.equals(Thread.currentThread())) {
				this.locked=false;
				System.out.println(Thread.currentThread().getName()+" "+"放弃monitor所有权");
				this.notifyAll();
			}
		}
		
	}

	@Override
	public List<Thread> getBlockedThreads() {
		return this.blocked;
	}

}
