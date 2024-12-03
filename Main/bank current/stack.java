
import java.io.Serializable;
import java.util.*;

public class stack implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<Object> ob = new ArrayList<Object>();
	protected int Apos = -1;

	stack() {
	}
	public void push(Object object) {
		Apos++;
		ob.add(Apos, object);
	}
	
	public Object pop() {
		Object object = new Object();
		object = ob.get(Apos);
		ob.remove(Apos);
		Apos--;
		return object;
	}
	
	public Object peak() {
		Object object = new Object();
		object = ob.get(Apos);
		return object;
	}
	
	public void remove(int pos) {
		ob.remove(Apos);
		Apos--;
	}
	public boolean isEmpty() {
		return(ob.isEmpty());
	}
	public int length() {
		return(Apos);
	}
}
