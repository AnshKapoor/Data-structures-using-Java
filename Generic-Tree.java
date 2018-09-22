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