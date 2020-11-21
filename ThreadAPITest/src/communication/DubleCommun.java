package communication;
/**
 * 单线程间的通信
 * @author pys
 * @ date 2020年7月15日 下午3:56:24
 */

import java.util.LinkedList;

public class DubleCommun {
	private final int max;
	private final LinkedList<Event> eventQueue = new LinkedList<Event>();
	private final static int DEFAULT_MAX_EVENT = 10;
	static class Event{
		
	}
	public DubleCommun() {
		this(DEFAULT_MAX_EVENT);
	}
	public DubleCommun(int max) {
		this.max = max;
	}
	
	public void off(Event event) {
		synchronized (eventQueue) {
			while(eventQueue.size()>=max) {
				console("the queue is full");
				try {
					eventQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			console("the new event is submitted"+eventQueue.size()+"  event  "+event);
			eventQueue.addLast(event);
			eventQueue.notifyAll();
		}
	}
	
	public Event task() {
		synchronized (eventQueue) {
			while(eventQueue.isEmpty()) {
				console("the queue is empty");
				try {
					eventQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			this.eventQueue.notifyAll();
			console("the event "+ event+"  is handled  "+eventQueue.size());
			return event;
		}
	}
	
	private void console(String msg) {
		System.out.println(Thread.currentThread().getName()+"  "+msg);
	}
}
