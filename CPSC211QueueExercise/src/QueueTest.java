import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest
{
    @Test
    public void testAddingAndRemoving()
    {
        Queue<Integer> queue = new QueueImplementation<Integer> ();
        
        queue.add(10);
        
        int item = queue.remove ();
        
        if (item != 10)
            fail ("Added 10, removed " + item);
        
        if (! queue.isEmpty())
            fail ("Added 10, removed it, but queue is not empty");
    }

    @Test
    public void testRemoveOnEmptyQueue()
    {
        Queue<Integer> queue = new QueueImplementation<Integer> ();
        
        Integer item = queue.remove ();
        
        if (item != null)
            fail ("Remove on empty queue returned " + item);
        
        if (! queue.isEmpty())
            fail ("Added 10, removed it, but queue is not empty");
    }
    
    @Test
    public void testIsEmpty()
    {
        Queue<Integer> queue = new QueueImplementation<Integer> ();

        if (! queue.isEmpty())
            fail ("Newly created queue not empty");
        
        queue.add(10);
        
        if (queue.isEmpty())
            fail ("Queue with one item reporting as empty");
        
        queue.remove ();
        
        if (! queue.isEmpty())
            fail ("Added 10, removed it, but queue is not empty");
    }
    
    @Test
    public void testOrder()
    {
        Queue<Integer> queue = new QueueImplementation<Integer> ();

        for (int i = 0; i < 10; i++)
            queue.add(i);

        for (int i = 0; i < 10; i++)
        {
            int item = queue.remove ();
            
            if (item != i)
                fail ("Expecting " + i + " on remove, got " + item);
        }
		
        if (! queue.isEmpty())
            fail ("Queue is not empty after removing all elements");
    }
    
    @Test
    public void testRemoveOrder()
    {
        Queue<Integer> queue = new QueueImplementation<Integer> ();

        queue.add(1);
        queue.add(2);
        queue.add(1);
        queue.add(2);

        int item = queue.remove();
        
        if (item != 1)
            fail ("Expecting 1, got " + item);
        
        item = queue.remove();
        
        if (item != 2)
            fail ("Expecting 2, got " + item);
        
        item = queue.remove();
        
        if (item != 1)
            fail ("Expecting 1, got " + item);
        
        item = queue.remove();
        
        if (item != 2)
            fail ("Expecting 2, got " + item);
   }
  
}
