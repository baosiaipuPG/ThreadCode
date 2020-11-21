package communication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class MyBooleanLock implements MyLock {
	//��ǰӵ�������߳�
	private Thread currentThread;
	//�Ƿ񱻻�ȡ��
	private boolean locked = false;
	//������Щ��ȡ�������������߳�
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
				 throw new IllegalArgumentException("mills �������0");
			}else {
				long remain = mills;
				long endmain = System.currentTimeMillis()+remain;
				while(locked) {
					if(remain<=0) {
						throw new TimeoutException("�߳�"+Thread.currentThread().getName()+"ʱ�䳬ʱ");
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
				System.out.println(Thread.currentThread().getName()+" "+"����monitor����Ȩ");
				this.notifyAll();
			}
		}
		
	}

	@Override
	public List<Thread> getBlockedThreads() {
		return this.blocked;
	}

}
