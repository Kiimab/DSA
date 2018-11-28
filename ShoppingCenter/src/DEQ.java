
public class DEQ<T> extends Queue<T> implements ExtendedQueueInterface<T> {

	public DEQ()
	{
		super();
	}

	@Override
	public void enqueueFirst(T newItem) throws ExtendedQueueException {
		checkSize();

		for (int i = (back - 1); i >= front; i--) {
			if (items[i] != null) {
				items[i + 1] = items[i];
			}
		}
		items[front] = newItem;
		back = (back + 1) % items.length;
		numItems++;

		checkSize();
	}

	@Override
	public T dequeueLast() throws ExtendedQueueException {
		if(isEmpty()) {
			throw new ExtendedQueueException("Queue is empty");
		}
		else {
			checkSize();

			T removedItem = (T) items[back - 1];
			items[back - 1] = null;
			numItems--;
			back = (back - 1) % items.length;

			checkSize();
			return removedItem;
		}

	}

	@Override
	public T peekLast() throws ExtendedQueueException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		else
		{
			return items[back - 1];
		}
	}
	
}