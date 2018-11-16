public class ListArrayListBasedPlus<T> extends ListArrayListBased<T> {

	public ListArrayListBasedPlus () {
		super();
	}

	public void reverse() {
		for(int i = 0, j = items.size() - 1; i < j; i++) {
			items.add(i, items.remove(j));
		}
	}
	public String toString()
	{
		String s="";
		for(int index =0; index <items.size(); index++)
		{
			s = s + items.get(index);
			index++;
		}
		return s;
	}
}
