public class DNode <T> {
	private T item;
	private DNode<T> next;
	private DNode<T> back;

	public DNode(T newItem) 
	{
		item = newItem;
		back = this;
		next = this;
	} // end constructor

	public DNode(T newItem, DNode<T> backNode, DNode<T> nextNode) 
	{
		item = newItem;
		back = backNode;
		next = nextNode;
	} // end constructor

	public void setItem(T newItem) 
	{
		item = newItem;
	} // end setItem

	public T getItem() 
	{
		return item;
	} // end getItem

	public void setNext(DNode<T> nextNode) 
	{
		next = nextNode;
	} // end setNext
	
	public void setBack(DNode<T> backNode) {
		back = backNode;
	} // end setBack

	public DNode getNext() 
	{
		return next;
	} // end getNext

	public DNode getBack()
	{
		return back;
	} // end getBack
}
