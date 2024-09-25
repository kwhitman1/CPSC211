import java.util.ArrayList;

public class QueueImplementation<T> implements Queue<T>{
	
	ArrayList<T> list = new ArrayList<T>();

	@Override
	public void add(T item) {
		list.add(item);
		
	}

	@Override
	public T remove() {
		if(!list.isEmpty()) {
			T top = list.remove(0);
			return top;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		}
		return false;
	}
	

}