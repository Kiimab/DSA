public class Queue<T> implements QueueInterface<T> {
	protected int front, back, numItems;
	protected T[] items;
	
	public Queue() {
		front = 0;
		back = 0;
		numItems = 0;
		
		items = (T[]) (new Object[3]);
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	public void enqueue(T newItem) throws QueueException {
		checkSize();
			
		items[back] = newItem;
		back = (back + 1) % items.length;
		numItems++;
		
		checkSize();
	}

	public T dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		checkSize();
		
		T removedItem = items[front];
		items[front] = null;
		numItems--;
		front = (front + 1) % items.length;
		
		checkSize();
		return removedItem;
	}

	public void dequeueAll() {
		while (numItems > 0) {
			dequeue();
		}
	}

	public T peek() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		return items[front];
	}

	protected void checkSize() {
		if (numItems == items.length) {

			T[] biggerQueue = (T[]) (new Object[items.length * 2]); 

			for (int i = 0; i < numItems; i++) 
			{
				biggerQueue[i] = items[(front + i) % items.length];
			}
			items = biggerQueue;
			front = 0;
			back = numItems;
		}
		else if((numItems > 0) && (numItems== items.length / 4)) {
			T[] smallerQueue = (T[]) (new Object[items.length / 2]);

			for (int i = 0; i < numItems; i++) 
			{
				smallerQueue[i] = items[(front + i) % items.length];
			}
			items = smallerQueue;
			front = 0;
			back = numItems;
		}
	}
	
	public String toString() {
		String result = "[";
		
		for (int i = front; i < (front + numItems); i++) {
			if (i == front && items[i] != null) {
				result = result + items[i].toString();
			}
			else if (items[i] != null) {
				result = result + ", " + items[i].toString();
			}
		}
		return result + "]";
	}
}
