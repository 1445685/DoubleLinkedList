package doubleLinkedList;

/**
 * Class representing a node in a list
 * 
 * @author no_$ignal_here
 * 
 * @version 0.6
 * */

public class Node<T> {
	private T value;
	private Node<T> next = null;
	private Node<T> previous = null;
	
	/**
	 * Build a new node with only the node value
	 * 
	 * @param value Generic value that the node will have
	 * */
	public Node(T value) {
		this.value = value;
	}
	/**
	 * Build a node by setting its value and the reference to the previous node.
	 * 
	 * @param value Generic value contained in the node
	 * @param previous Node previous to the node being created
	 * */
	public Node(T value, Node<T> previous) {
		this.value = value;
		this.previous = previous;
	}
	/**
	 * Create a node with a generic value and references to both the next node and the previous node.
	 * 
	 * @param value Generic value contained in the node
	 * @param previous Node previous to the node being created
	 * @param next Node next to the node being created
	 * */
	public Node(T value, Node<T> previous, Node<T> next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
	
	/**
	 * Get the value contained by the node
	 * 
	 * @return Returns the value of the node
	 * */
	public T getValue() {return this.value;}
	/**
	 * Modifies the value contained by the node
	 * 
	 * @param newValue New value that will contain node 
	 * */
	public void setValue(T newValue) {this.value = newValue;}
	
	/**
	 * Get a reference to the next node
	 * 
	 * @return Reference to the next node of the current node
	 * */
	public Node<T> getNextNode() {return this.next;}
	/**
	 * Modify the following node of the current node
	 * 
	 * @param newNextNode New reference to a node
	 * */
	public void setNextNode(Node<T> newNextNode) {this.next = newNextNode;}
	
	/**
	 * Gets the node referenced as the one before the current node
	 * 
	 * @return Reference to a node
	 * */
	public Node<T> getPreviousNode() {return this.previous;}
	/**
	 * Modify the reference to the previous node
	 * 
	 * @param newPreviousNode New reference to a node
	 * */
	public void setPreviousNode(Node<T> newPreviousNode) {this.previous = newPreviousNode;}
	
	/**
	 * Create a string with/display the most important information about the node, the value
	 * 
	 * @return Returns the most important information about the node as a string
	 * */
	public String toString() {
		return "[value: " + this.value + "]\n";
	}
	/**
	 * Checks whether an object is equal to the current node using the node value as a reference
	 * 
	 * @param otherObject Object with which the current node is to be compared
	 * 
	 * @return Returns a boolean value. true if both are equal, false if they are not
	 * */
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
		if (otherObject == null) {return false;}
		if (!(otherObject instanceof Node other)) {return false;}
		return this.value.equals(other.getValue());
	}
}
