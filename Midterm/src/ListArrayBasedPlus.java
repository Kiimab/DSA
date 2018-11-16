public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

	public ListArrayBasedPlus () {
		super();
	}

	public void reverse() {
		for(int i=0; i < items.length/2; i++) {
			T temp = items[i];
			items[i] = items[items.length -i -1];
			items[items.length -i -1] = temp;
		}
	}
	public String toString()
	{
		String s="";
		for(int index= 0; index <items.length; index++)
		{
			s = s + items[index];
			index++;
		}
		return s;
	}
}
