import java.util.ArrayList;

public class StackImplementation<T> implements Stack<T>{
	
	ArrayList<T> list = new ArrayList<T>();

	@Override
	public void push(T item) {
		list.add(item);
		
	}

	@Override
	public T pop() {
		if(list.size() >= 1) {
			T top = list.get(list.size() - 1);
			list.remove(list.size() - 1);
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
