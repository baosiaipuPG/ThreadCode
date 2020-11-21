package ThreadPool;

@FunctionalInterface
public interface DenyPolicyP {
	/**
	 * 
	 * @Title reject
	 * @param runnable
	 * @param threadFactoryP
	 * @Description �ܾ����Է���
	 * @throws
	 */
	void reject(Runnable runnable,ThreadPoolP threadPoolP);
	
	class DiscardDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			// TODO Auto-generated method stub
			System.out.println(" DiscardDenyPolicyP ֱ�ӷ�������");
		}
		
	}
	
	class AbortDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			System.out.println("AbortDenyPolicyP  �����������������ʧ��");
			throw new RunnableDenyExceptionP("�����������������ʧ��");
		}
		
	}
	
	class RunnerDenyPolicyP implements DenyPolicyP{

		@Override
		public void reject(Runnable runnable, ThreadPoolP threadPoolP) {
			if(!threadPoolP.isShutdown()) {
				System.out.println("RunnerDenyPolicyP ���ύ�ߵ��߳���ִ��");
				runnable.run();
			}
		}
		
	}
}
