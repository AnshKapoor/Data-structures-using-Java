public class StackUsingLL {
	private LinkedList list;

	public StackUsingLL() {
		// TODO Auto-generated constructor stub
		this.list = new LinkedList();
	}

	public int size() {
		return this.list.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
