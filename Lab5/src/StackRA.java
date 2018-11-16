public class StackRA<T> implements StackInterface<T> {

	private T[] items;
	private int numItems;

	public StackRA() {
		items = (T[]) (new Object[3]);
		numItems = 0;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void popAll() {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			int numberOfPops = numItems;
			for (int i = 0; i < numberOfPops; i++) {
				pop();
			}
		}
	}

	public void push(T newItem) throws StackException {
		if (numItems == (items.length - 1)) {
			expand();
		}

		items[numItems] = newItem;
		numItems++;
	}

	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			T temp = items[numItems - 1];
			items[numItems - 1] = null;
			numItems--;

			if (numItems > 0 && numItems == items.length / 4) {
				shrink();
			}
			return temp;
		}
	}

	public T peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			return items[numItems - 1];
		}
	}

	public void expand() {
		T[] temp = (T[]) new Object[2 * items.length];
		for (int i = 0; i < numItems; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	public void shrink() {
		T[] temp = (T[]) new Object[items.length / 2];
		for (int i = 0; i < numItems; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	public String toString() {
		String s = "";
		for (int i = numItems - 1; i >= 0; i--) {
			s = s + "\n" + items[i];
		}
		return s;
	}
}
