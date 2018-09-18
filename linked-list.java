public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
            public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.isEmpty()) {
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}
private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}
		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}

		return temp;
	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}
		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node node = new Node(data, temp.next);
			temp.next = node;
			this.size++;
		}

	}
                public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;
	}

public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		return this.getNodeAt(index).data;
	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node nm2 = getNodeAt(this.size - 2);
			nm2.next = null;
			this.tail = nm2;
		}
		this.size--;
	}

	public void removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (index == 0) {
			this.removeFirst();
		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(index - 1);
			nm1.next = nm1.next.next;
			this.size--;
		}
	}
public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node templeft = this.getNodeAt(left);
			Node tempright = this.getNodeAt(right);

			int temp = templeft.data;
			templeft.data = tempright.data;
			tempright.data = temp;
			left++;
			right--;

		}
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tempprev = prev;
			Node tempcurr = curr;

			prev = curr;
			curr = curr.next;
			tempcurr.next = tempprev;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (node == this.tail) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}
public void reverseDR() {
		HeapMover obj = new HeapMover(this.head);
		reverseDR(obj, this.head, 0);
	}

	private void reverseDR(HeapMover left, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR(left, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	public int mid() {
		return getMidNode().data;
	}

	private Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
public int kthfromLast(int index) throws Exception {
		if (index == 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < index; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

public LinkedList merge(LinkedList other) {
		LinkedList rv = new LinkedList();

		Node thistemp = this.head, othertemp = other.head;
		while (thistemp != null && othertemp != null) {
			if (thistemp.data < othertemp.data) {
				rv.addLast(thistemp.data);
				thistemp = thistemp.next;
			} else {
				rv.addLast(othertemp.data);
				othertemp = othertemp.next;
			}
		}

		while (thistemp != null) {
			rv.addLast(thistemp.data);
			thistemp = thistemp.next;
		}
		while (othertemp != null) {
			rv.addLast(othertemp.data);
			othertemp = othertemp.next;
		}

		return rv;
	}
                public void MergeSort() {
		LinkedList sorted = mergeSortHelper(this.head, this.tail);
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;

	}

	        private LinkedList mergeSortHelper(Node low, Node high) {
		if (this.size() == 1) {
			return this;
		}

		Node mid = getMidNode();
		Node midnext = mid.next;
		mid.next = null;

		LinkedList list1 = new LinkedList(low, mid, (this.size() + 1) / 2);
		LinkedList list2 = new LinkedList(midnext, high, this.size() / 2);

		list1.MergeSort();
		list2.MergeSort();

		return list1.merge(list2);
	}
private LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}
}




