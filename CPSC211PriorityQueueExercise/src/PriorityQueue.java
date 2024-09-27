
public interface PriorityQueue<T extends Comparable<T>>
{
    void add (T item);
	// Remove largest item, if queue is empty return null
    T remove ();
    boolean isEmpty ();
}