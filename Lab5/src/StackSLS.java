public class StackSLS<T> implements StackInterface<T> {

	private MyListReferenceBased<T> items;

	public StackSLS() {
		items = new MyListReferenceBased<>();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public void popAll() {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			int numberOfPops = items.size();
			for (int i = 0; i < numberOfPops; i++) {
				pop();
			}
		}
	}

	public void push(T newItem) throws StackException {
		items.add(items.size(), newItem);
	}

	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			T temp = (T) items.get(items.size() - 1);
			items.remove(items.size() - 1);
			return temp;
		}
	}

	public T peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		else {
			return (T) items.get(items.size() - 1);
		}
	}

	public String toString() {
		String s = "";
		for (int i = items.size() - 1; i >= 0; i--) {
			s = s + "\n" + items.get(i);
		}
		return s;
	}
}