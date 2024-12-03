import java.io.Serializable;
import java.util.ArrayList;

public class queue implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private int rear;
	private int front;
	private int maxSize;
	queue(int mcSize){
		rear = -1;
		front = -1;
		this.maxSize=mcSize;
		
	}
	private ArrayList<Object> ob = new ArrayList<Object>(maxSize);
	public void enQueue(Object object) {
		if (ob.isEmpty()) {
		rear = 0;
		front = 0;
		ob.add(rear,object);
		} else {
			rear = rear+1;
			if (rear == front) {
				System.out.println("queue is full, add more allocation to maxSize");
				rear = rear - 1;
			} else {
				ob.add(rear, object);
			}
		}
	}
	
	public Object deQueue(){
		Object object;
		object = ob.get(front);
		if (!ob.isEmpty()) {
			if (front == rear) {
			front = 0;
			}else {
				 front = front + 1;
			}
		}
		 else 
	        {
	            System.out.println("Queue is empty. Cannot dequeue.");
	        }
		return (object);
	}
	public Object peak() {
		Object object = new Object();
		 if (!ob.isEmpty()) 
	        {
			 object = ob.get(front);
	            return object;
	        } 
	       else 
	        {
	            System.out.println("Queue is empty. No peek value.");
	        }
		return null;
	}
	public boolean ISempty() {
		if (rear == front) {
			return (true);
		} else return (false);
	}
	public int Size() {
		
		return rear;
	}
}
