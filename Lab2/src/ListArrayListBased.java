// ********************************************************
// ArrayList-based implementation of the ADT list.
// *********************************************************
import java.util.ArrayList;
public class ListArrayListBased<T> implements ListInterface<T>
{

    protected final int MAX_LIST = 3; // fixes memory leak //fixes programming style
    protected ArrayList<T> items;  // an arrayList of list items
    protected int numItems;  // number of items in list

    public ListArrayListBased()
    {
        items = new ArrayList<>();
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void removeAll()
    {
        // Creates a new arrayList; marks old arrayList for
        // garbage collection.
        items = new ArrayList<>();
        numItems = 0;
    } // end removeAll

    public void add(int index, T item)
    		throws  ListIndexOutOfBoundsException
    {
        if (numItems >= MAX_LIST) // fixes implementation error
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items.add(item);
            } // end for
            // insert new item
            items.add(index, item);
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add

    public T get(int index)
    		throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items.get(index);
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items.remove(get(index));
            }  // end for
            numItems--;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
    
    public String toString()
    {
    	return items.toString();
    }
}
