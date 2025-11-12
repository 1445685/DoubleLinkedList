package doubleLinkedList;

public class Node {
	private int value;
	private Node next = null;
	private Node previous = null;
	
	public Node(int value) {
		this.value = value;
	}
	public Node(int value, Node previous) {
		this.value = value;
		this.previous = previous;
	}
	public Node(int value, Node previous, Node next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
	
	public int getValue() {return this.value;}
	public void setValue(int newValue) {this.value = newValue;}
	
	public Node getNextNode() {return this.next;}
	public void setNextNode(Node newNextNode) {this.next = newNextNode;}
	
	public Node getPreviousNode() {return this.previous;}
	public void setPreviousNode(Node newPreviousNode) {this.previous = newPreviousNode;}
	
	public String toString() {
		return "[value: " + this.value + "\n";
	}
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
		if (otherObject == null) {return false;}
		if (!(otherObject instanceof Node other)) {return false;}
		return this.value == other.getValue();
	}
}
