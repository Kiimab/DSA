public class CDLS <T>{
	// reference to doubly linked list of items
	//private DNode<T> head;
	private DNode<T> tail;
	private int numItems;

	public CDLS() 
	{
		//head = null;
		numItems = 0;
		tail = null;
	}  // end default constructor

	public boolean isEmpty() 
	{
		return tail == null;
	}  // end/ isEmpty

	public int size() 
	{
		return numItems;
	}  // end size

	private DNode<T> find(int index) 
	{
		// --------------------------------------------------
		// Locates a specified node in a linked list.
		// Precondition: index is the number of the desired
		// node. Assumes that 0 <= index <= numItems 
		// Postcondition: Returns a reference to the desired 
		// node.
		// --------------------------------------------------
		DNode<T> head = (DNode<T>) tail.getNext();
		DNode<T> curr = null;
		
		if (index < numItems / 2)
		{
			curr = head;
			for (int skip = 0; skip < index; skip++)
			{
				curr = (DNode<T>) curr.getNext();
			}
		}
		else // index >= numItems / 2
		{
			curr = tail;
			for (int skip = 0; skip < (numItems - 1) % index; skip++)
			{
				curr = (DNode<T>) curr.getBack();
			}
		}
		
		return curr;
	} // end find

	public String toString()
	{
		String s="";

		if (!isEmpty())
		{
			DNode<T> temp = (DNode<T>) tail.getNext(); // start at the head
			for (int i = 0; i < numItems; i++)
			{
				s += temp.getItem() + " ";
				temp = (DNode<T>) temp.getNext();
			}
		}
		return s;
	}   

	public T get(int index) 
			throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < size()) 
		{
			// get reference to node, then data in node
			DNode<T> curr = find(index);
			T dataItem = curr.getItem();
			return dataItem;
		} 
		else 
		{
			throw new ListIndexOutOfBoundsException(
					"List index out of bounds exception on get");
		} // end if
	} // end get

	public void add(int index, T item)
			throws ListIndexOutOfBoundsException 
	{

		if (index >= 0 && index <= size()) 
		{
			if (index == 0) 
			{
				if (isEmpty()) 
				{
					DNode<T> newNode = new DNode<T>(item);
					tail = newNode;
				}
				else {
					// insert the new node containing item at
					// beginning of list
					DNode<T> head = (DNode<T>) tail.getNext();
					DNode<T> newNode = new DNode<T>(item, tail, head);
					head.setBack(newNode);
					tail.setNext(newNode);
				}
			}
			else if (index == size()) 
			{
				DNode<T> prev = tail;
				DNode<T> next = (DNode<T>) tail.getNext();
				
				DNode<T> newNode = new DNode<T>(item, prev, next);
				prev.setNext(newNode);
				next.setBack(newNode);
//				newNode.getBack().setNext(newNode);
//				newNode.getNext().setBack(newNode);
				tail = newNode;
			}
			else 
			{
				DNode<T> prev = find(index-1);
				DNode<T> next = (DNode<T>) prev.getNext();
				// insert the new node containing item after 
				// the node that previous references
				DNode<T> newNode = new DNode<T>(item, prev, next);
				prev.setNext(newNode);
				next.setBack(newNode);
//				newNode.getBack().setNext(newNode);
//				newNode.getNext().setBack(newNode);
			} // end if
			numItems++;
		} 
		else 
		{
			throw new ListIndexOutOfBoundsException(
					"List index out of bounds exception on add");
		} // end if
	}  // end add

	public void remove(int index) 
			throws ListIndexOutOfBoundsException 
	{
		if (index >=0 && index < size()) 
		{
			if (size() == 1) {
				tail = null;
			}
			else if (index == 0) 
			{
				// delete the first node from the list
				DNode<T> head = (DNode<T>) tail.getNext();
				DNode<T> newHead = (DNode<T>) head.getNext();
				tail.setNext(newHead);
				newHead.setBack(tail);
				head = null;
			} 
			else if (index == size())
			{
				// delete the last node from the list
				DNode<T> newTail = (DNode<T>) tail.getBack();
				DNode<T> head = (DNode<T>) tail.getNext();
				newTail.setNext(head);
				head.setBack(newTail);
				tail = newTail;
			}
			else 
			{
				// delete the node after the node that prev
				// references, save reference to node
				DNode<T> prev = find(index-1);
				DNode<T> curr = (DNode<T>) prev.getNext();
				DNode<T> newNext = (DNode<T>) curr.getNext();
				
				// set prev's next to curr's next
				prev.setNext(newNext);
				newNext.setBack(prev);
				
				// delete the 'old' next
				curr = null;
			}
			numItems--;
		} // end if
		else
		{
			throw new ListIndexOutOfBoundsException(
				"List index out of bounds exception on remove");
		} // end if
	}   // end remove1	 

	public void removeAll() 
	{
		// setting tail to null causes list to be
		// unreachable and thus marked for garbage 
		// collection
		tail = null;
		numItems = 0;
	} // end removeAll
}
