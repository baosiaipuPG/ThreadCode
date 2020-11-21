package ThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueueP implements RunnableQueueP{
	//��������������
	private final int maxSize;
	//�ܾ�����
	private final DenyPolicyP denyPolicyP;
	//�������
	private final LinkedList<Runnable> runList = new LinkedList<Runnable>();
	
	private final ThreadPoolP threadPoolP;
	
	
	public LinkedRunnableQueueP(int maxSize, DenyPolicyP denyPolicyP, ThreadPoolP threadPoolP) {
		this.maxSize = maxSize;
		this.denyPolicyP = denyPolicyP;
		this.threadPoolP = threadPoolP;
	}
	

	@Override
	public void offer(Runnable runnable) {
		synchronized (runList) {
			if(runList.size()>=maxSize) {
				//�����������ִ�оܾ�����
				System.out.println(Thread.currentThread().getName()+" ������ִ�оܾ����� "+  threadPoolP.getQueueSize());
				denyPolicyP.reject(runnable, threadPoolP);
			}else {
				//�����������ӵ���β�����һ����߳�
				runList.addLast(runnable);
				runList.notifyAll();
			}
		}
	}

	@Override
	public Runnable task() throws InterruptedException{
		synchronized (runList) {
			while(runList.isEmpty()) {
				try {
					//�������Ϊ�����̹߳���
					runList.wait();
				} catch (InterruptedException e) {
					throw e;
				}
			}
			//�Ӷ���ͷ���Ƴ�һ������
			return runList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized (runList) {
			return runList.size();
		}
	}

}
