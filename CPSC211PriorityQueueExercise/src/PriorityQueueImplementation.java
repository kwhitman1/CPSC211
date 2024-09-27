import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueImplementation<T extends Comparable<T>> implements PriorityQueue<T>{
	
	ArrayList<T> list = new ArrayList<T>();

	@Override
	public void add(T item) {
		list.add(item);
		Collections.sort(list);
		
	}

	@Override
	public T remove() {
		if(!list.isEmpty()) {
			T top = list.remove(list.size() - 1);
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