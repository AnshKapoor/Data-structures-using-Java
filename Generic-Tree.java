import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			children = new ArrayList<>();
		}
	}
        private Node root;
	private int size = 0;

	GenericTree() {
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, 0);
	}
private Node takeInput(Scanner s, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter the data for root Node");
		} else {
			System.out.println("Enter the data for " + ithchild + " th child of " + parent.data);
		}
		int nodeData = s.nextInt();
		Node node = new Node(nodeData);
		this.size++;
		System.out.println("Please enter the number of children for " + node.data);
		int numChildren = s.nextInt();
		for (int i = 0; i < numChildren; i++) {
			Node child = this.takeInput(s, node, i);
			node.children.add(child);
		}
		return node;
	}
public int size() {
		return this.size;
	}

	public void display() {
		this.display(this.root);
	}

private void display(Node node) {
		System.out.print(node.data + "=>");
		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data + ",");
		}
		System.out.println("END");
		for (int i = 0; i < node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

private int size2(Node node) {
		int rv = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int childSize = this.size2(node.children.get(i));
			rv = rv + childSize;
		}

		rv = rv + 1;

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			int maxinchild = this.max(node.children.get(i));
			if (maxinchild > max) {
				max = maxinchild;
			}
		}

		return max;
	}
