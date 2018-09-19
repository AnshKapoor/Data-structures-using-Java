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
public void push(int item) {
		this.list.addFirst(item);
	}

	public int pop() throws Exception {
		int rv = this.list.getFirst();
		this.list.removeFirst();
		return rv;
	}

	public int top() throws Exception {
		return this.list.getFirst();
	}
