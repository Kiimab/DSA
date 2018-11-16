// Please note that this code is slightly different from the textbook code 
//to reflect the fact that the Node class is implemented using data encapsulation
// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class MyListReferenceBased<T> implements ListInterface <T>
{
	// reference to linked list of items
	private Node<T> head; 

	public MyListReferenceBased() 
	{
		head = null;
	}  // end default constructor

	public boolean isEmpty() 
	{
		return head == null;
	}  // end/ isEmpty

	public int size() 
	{
		int size= 0;
		Node<T> temp = head;

		if (temp != null) {
			size++;
			while (temp.getNext() != null)
			{
				temp = temp.getNext();
				size++;
			}
		}
		return size;
	}  // end size

	private Node<T> find(int index) 
	{
		// --------------------------------------------------
		// Locates a specified node in a linked list.
		// Precondition: index is the number of the desired
		// node. Assumes that 0 <= index <= numItems 
		// Postcondition: Returns a reference to the desired 
		// node.
		// --------------------------------------------------
		Node<T> curr = head;
		for (int skip = 0; skip < index; skip++) 
		{
			curr = curr.getNext();
		} // end for
		return curr;
	} // end find

	public String toString()
	{
		String s="";
		Node<T> temp = head;

		if (temp != null)
		{
			s += temp.getItem();
			while(temp.getNext() != null) {
				s += temp.getItem();
				temp = temp.getNext();
			}
		}
		return s;
	}   

	public T get(int index) 
			throws ListIndexOutOfBoundsException 
	{
		if (index == 0 || index < size()) 
		{
			// get reference to node, then data in node
			Node<T> curr = find(index);
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

		if (index == 0 || index <= size()) 
		{
			if (index == 0) 
			{
				// insert the new node containing item at
				// beginning of list
				Node<T> newNode = new Node<T>(item, head);
				head = newNode;	
			} 
			else 
			{
				Node<T> prev = find(index-1);
				// insert the new node containing item after 
				// the node that previous references
				Node<T> newNode = new Node<T>(item, prev.getNext());
				prev.setNext(newNode);
			} // end if
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
			if (index == 0) 
			{
				// delete the first node from the list
				head = head.getNext();
			} 
			else 
			{
				Node<T> prev = find(index-1);
				// delete the node after the node that prev
				// references, save reference to node
				Node<T> curr = prev.getNext(); 
				prev.setNext(curr.getNext());
			}				
		} // end if
		else
		{
			throw new ListIndexOutOfBoundsException(
					"List index out of bounds exception on remove");
		} // end if
	}   // end remove1	 

	public void removeAll() 
	{
		// setting head to null causes list to be
		// unreachable and thus marked for garbage 
		// collection
		head = null;
	} // end removeAll

} // end ListReferenceBased
