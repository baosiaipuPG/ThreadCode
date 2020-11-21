package semaphore;

import java.util.stream.IntStream;

public class ThreadYieldTest {

	public static void main(String[] args) {
		IntStream.range(0, 3)
				.mapToObj(ThreadYieldTest::create)
				.forEach(Thread::start);
							

	}
	private static Thread create(int index) {
		return new Thread(()->{
			if(index==0)
				Thread.yield();
			System.out.println(index);
		}) ;
	}

}
