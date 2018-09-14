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

