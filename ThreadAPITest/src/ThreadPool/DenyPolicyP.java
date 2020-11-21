package ThreadPool;

@FunctionalInterface
public interface DenyPolicyP {
	/**
	 * 
	 * @Title reject
	 * @param runnable
	 * @param threadFactoryP
	 * @Description 拒绝策略方法
	 * @throws
	 */
	void reject(Runnable runnable,ThreadPoolP threadPoolP);
	
	class DiscardDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			// TODO Auto-generated method stub
			System.out.println(" DiscardDenyPolicyP 直接放弃任务");
		}
		
	}
	
	class AbortDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			System.out.println("AbortDenyPolicyP  队列已满，添加任务失败");
			throw new RunnableDenyExceptionP("队列已满，添加任务失败");
		}
		
	}
	
	class RunnerDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			if(!threadPoolP.isShutdown()) {
				System.out.println("RunnerDenyPolicyP 在提交者的线程中执行");
				runnable.run();
			}
		}
		
	}
}
