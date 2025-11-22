package doubleLinkedList;

import java.util.NoSuchElementException;

/**
 * Class that implements the logic of a simple doubly linked list
 * @see <a src="https://en.wikipedia.org/wiki/Doubly_linked_list">Wikipedia article on doubly linked lists</a>
 * 
 * @author no_$ignal_here
 * 
 * @version 0.6
 * */

public class DoubleLinkedList<T> {
	private int lenght = 0;
	private Node<T> firstNode = null;
	private Node<T> lastNode = null;

	// ------ constructors
	/**
	 * Build a new, completely empty list
	 * */
	public DoubleLinkedList() {}
	/**
	 * Build a new list with an initial node
	 * 
	 * @param firstNode The first node in the list
	 * */
	public DoubleLinkedList(Node<T> firstNode) {
		this.firstNode = firstNode;
		this.lastNode = firstNode;
		this.lenght++;
	}
	/**
	 * Build a new list containing a node with the specified value
	 * 
	 * @param valueValue contained in the first node
	 * */
	public DoubleLinkedList(T value) {
		this(new Node<T>(value));
	}

	// ------ methods
	/**
	 * This method searches the list for the node passed as an argument
	 * 
	 * @param node Node being searched for in the list
	 * 
	 * @return Returns the index at which the node appears in the list
	 *  If the node does not exist in the list, returns -1;
	 *  If the list is empty, return 0.
	 * */
	private int existsInList(Node<T> node) {
		if (this.lenght == 0) {return 0;}
		
		int index = 1;
		Node<T> aux = this.getFirstNode();
		
		while (index <= this.getLength()) {
			if(aux.equals(node)) {return index;}
			aux = aux.getNextNode();
			
			index++;
		}
		
		return -1;
	}
	/**
	 * Check if the list is empty or has at least one node 
	 * 
	 * @return Returns a Boolean specifying whether the size of the list is equal to zero (true) or not (false)
	 * */
	private boolean emptyList() {
		return this.getLength() == 0;
	}
	/**
	 * Initialize the list with the specified node
	 * 
	 * @param node Node that will initialize the list
	 * */
	public void initializeList(Node<T> node) {
		node.setNextNode(null);
		node.setPreviousNode(null);
		
		this.firstNode = node;
		this.lastNode = node;
	}
	/**
	 * Clears the list by leaving it without references in the firstNode and lastNode attributes.
	 * */
	public void cleanList() {
		this.firstNode = null;
		this.lastNode = null;
	}
	
	/**
	 * Insert a node at the first position in the list and shift the other elements
	 * 
	 * @param newNode Node to be inserted
	 * 
	 * @return Nothing at the moment
	 * */
	public void insertFirstNode(Node<T> newNode) {
		if (this.emptyList()) {
			this.initializeList(newNode);
		} else {
			newNode.setNextNode(this.getFirstNode());
			this.getFirstNode().setPreviousNode(newNode);
			this.firstNode = newNode;
		}
		
		this.lenght++;
	}
	/**
	 * Insert a node at the end of the list
	 * 
	 * @param newNode Node to be inserted
	 * 
	 * @return Nothing at the moment
	 * */
	public void insertLastNode(Node<T> newNode) {
		if (this.emptyList()) {
			this.initializeList(newNode);
		} else {
			this.getLastNode().setNextNode(newNode);
			newNode.setPreviousNode(this.getLastNode());
			this.lastNode = newNode;
		}
		
		this.lenght++;
	}
	/**
	 * Insert a node before the specified node
	 * 
	 * @param node Node used as a reference when inserting a new node
	 * @param newNode Node to be inserted 
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws NoSuchElementException Exception indicating that the node used as a reference does not exist in the list
	 * */
	public void insertBeforeNode(Node<T> node, Node<T> newNode) throws NoSuchElementException, IllegalStateException {
		int indexNode = this.existsInList(node);
		
		if (indexNode == 0) {throw new IllegalStateException("There are no items in the list");}
		if (indexNode == -1) {throw new NoSuchElementException("The specified node does not exist in the list");}
		
		if (indexNode == 1) {
			this.insertFirstNode(newNode);
		} else {
			Node<T> previousNode = node.getPreviousNode();
			
			newNode.setNextNode(node);
			newNode.setPreviousNode(previousNode);
			
			previousNode.setNextNode(newNode);
			node.setPreviousNode(newNode);
			
			this.lenght++;
		}
	}
	/**
	 * Insert a node after the specified node
	 * 
	 * @param node Node used as a reference when inserting a new node
	 * @param newNode Node to be inserted 
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws NoSuchElementException Exception indicating that the node used as a reference does not exist in the list
	 * */
	public void insertAfterNode(Node<T> node, Node<T> newNode) throws NoSuchElementException, IllegalStateException {
		int indexNode = this.existsInList(node);

		if (indexNode == 0) {throw new IllegalStateException("There are no items in the list");}
		if (indexNode == -1) {throw new NoSuchElementException("The specified node does not exist in the list");}
		
		if (indexNode == this.getLength()) {
			this.insertLastNode(newNode);
		} else {
			Node<T> nextNode = node.getNextNode();
			
			newNode.setNextNode(nextNode);
			newNode.setPreviousNode(node);
			
			nextNode.setPreviousNode(newNode);
			node.setNextNode(newNode);
			this.lenght++;
		}
	}
	
	/**
	 * Remove the first node and shift the list
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws IllegalStateException Throws an exception when trying to access an empty list.
	 * */
	public void removeFirstNode() throws IllegalStateException {
		if (this.lenght == 0) {throw new IllegalStateException("Empty list");}
		
		if (this.getLength() == 1) {
			this.cleanList();
		} else {
			this.firstNode = this.getFirstNode().getNextNode();
			this.getFirstNode().setPreviousNode(null);
		}
		
		this.lenght--;
	}
	/**
	 * Remove the last node and shift the list
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws IllegalStateException Throws an exception when trying to access an empty list.
	 * */
	public void removeLastNode() throws IllegalStateException {
		if (this.lenght == 0) {throw new IllegalStateException("Empty list");}
		
		if (this.lenght == 1) {
			this.cleanList();
		} else {
			this.lastNode = this.getLastNode().getPreviousNode();
			this.getLastNode().setNextNode(null);
		}
		
		this.lenght--;
	}
	/**
	 * Remove the specified node from the list
	 * 
	 * @param node Node to be removed from the list
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws NoSuchElementException Exception indicating that the node to be deleted does not exist in the list
	 * @throws IndexOutOfBoundsException If the first node is passed as a reference, an exception will be raised because there is no node preceding it.
	 * */
	public void removeBeforeNode(Node<T> node) throws NoSuchElementException, IndexOutOfBoundsException {
		int indexNode = this.existsInList(node);

		if (indexNode == 0) {throw new IllegalStateException("There are no items in the list");}
		if (indexNode == -1) {throw new NoSuchElementException("The specified node does not exist in the list");}
		if (indexNode == 1) {throw new IndexOutOfBoundsException("This attempts to delete the node before the first one, which does not exist.");}
		
		if (indexNode == 2) {
			this.removeFirstNode();
		} else {
			Node<T> previousNode = node.getPreviousNode().getPreviousNode();
			
			node.setPreviousNode(previousNode);
			previousNode.setNextNode(node);
			
			this.lenght--;
		}
	}
	/**
	 * Remove the specified node from the list
	 * 
	 * @param node Node to be removed from the list
	 * 
	 * @return Nothing at the moment
	 * 
	 * @throws NoSuchElementException Exception indicating that the node to be deleted does not exist in the list
	 * @throws IndexOutOfBoundsException If the last node is passed as a reference, an exception is raised because an attempt is made to delete a node that does not exist
	 * */
	public void removeAfterNode(Node<T> node) throws NoSuchElementException, IndexOutOfBoundsException {
		int indexNode = this.existsInList(node);
		
		if (indexNode == 0) {throw new IllegalStateException("There are no items in the list");}
		if (indexNode == -1) {throw new NoSuchElementException("The specified node does not exist in the list");}
		if (indexNode == this.lenght) {throw new IndexOutOfBoundsException("This attempts to delete the node following the last one, which does not exist");}
		
		if (indexNode == this.getLength()-1) {
			this.removeLastNode();
		} else {
			Node<T> nextNode = node.getNextNode().getNextNode();
			
			node.setNextNode(nextNode);
			nextNode.setPreviousNode(node);
			
			this.lenght--;
		}
	}
	
	// ------ gets and sets
	/**
	 * Returns the size of the list
	 * 
	 * @return size of list
	 * */
	public int getLength() {return this.lenght;} 
	
	/**
	 * Returns the first node in the list
	 * 
	 * @return Reference to the first node of the list
	 * */
	public Node<T> getFirstNode() {return this.firstNode;}
	/**
	 * Modify the first node in the list
	 * 
	 * @param newFirstNode The node that will replace the first node in the list
	 * */
	public void setFirstNode(Node<T> newFirstNode) {
		// Reference to the second node in the list or to null
		Node<T> nextNodeOfFirstNode = this.getFirstNode().getNextNode();
		
		//  Modify the previous and next node references if there is a second node in the list.
		//  If there is no second node in the list, then the reference to lastNode must also be
		// modified because there is only one node in the list.
		if (nextNodeOfFirstNode != null) {
			nextNodeOfFirstNode.setPreviousNode(newFirstNode);
			newFirstNode.setNextNode(nextNodeOfFirstNode);
		} else {
			this.lastNode = newFirstNode;
		}
		
		this.firstNode = newFirstNode;
	}
	
	/**
	 * Returns the last node in the list
	 * 
	 * @return Reference to the last node of the list
	 * */
	public Node<T> getLastNode() {return this.lastNode;}
	/**
	 * Modify the last node in the list
	 * 
	 * @param newLastNode The node that will replace the last node in the list
	 * */
	public void setLastNode(Node<T> newLastNode) {
		// Reference to the penultimate node in the list
		Node<T> previousNodeOfLastNode = this.getLastNode().getPreviousNode();
		
		//  If there is a penultimate node, then the previous and next node references are modified. 
		//  If there is no penultimate node, then the list has only one node and the firstNode 
		// reference must also be modified.
		if (previousNodeOfLastNode != null) {
			newLastNode.setPreviousNode(previousNodeOfLastNode);
			previousNodeOfLastNode.setNextNode(newLastNode);
		} else {
			this.firstNode = newLastNode;
		}
		
		this.lastNode = newLastNode;
	}
	
	// ------ toString and equals
	/**
	 * Displays useful information from the list: firstNode, lastNode, and length.
	 * 
	 * @return String with the information from the list
	 * */
	public String toString() {
		return "[length: " + this.lenght +
				"\n" + "\tfirst node: " + this.firstNode +
				"\n" + "\tlast node: " + this.lastNode +
				"]\n";
	}
	
	/**
	 * Check if two lists are equal by iterating and comparing each node
	 * 
	 * @param otherObject The other object with which you want to compare the list
	 * 
	 * @return Returns a boolean indicating whether the objects are the same (true) or different (false).
	 * */
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
		if (otherObject == null) {return false;}
		if (!(otherObject instanceof DoubleLinkedList<?> other)) {return false;}
		if (this.lenght != other.getLength()) {return false;}
		
		int index = 0;
		
		Node<?> auxNode = this.firstNode;
		Node<?> otherActualNode = other.getFirstNode();
		
		while (index < this.lenght) {
			if (!auxNode.equals(otherActualNode)) {return false;}
			
			auxNode = auxNode.getNextNode();
			otherActualNode = otherActualNode.getNextNode();
			
			index++;
		}
		return true;
	}
}
