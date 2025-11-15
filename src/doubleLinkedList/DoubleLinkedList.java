package doubleLinkedList;

public class DoubleLinkedList {
	private int lenght = 0;
	private Node firstNode = null;
	private Node lastNode = null;
	private Node actualNode = null;

	// ------ constructors
	public DoubleLinkedList() {}
	public DoubleLinkedList(Node firstNode) {
		this.firstNode = firstNode;
		this.lastNode = firstNode;
		this.lenght++;
	}
	public DoubleLinkedList(int value) {
		this(new Node(value));
	}

	// ------ methods
	public void add(Node newNode) {
		newNode.setNextNode(this.actualNode.getNextNode());
		this.actualNode.setNextNode(newNode);
	}
	public void add(int value) {
		this.add(new Node(value));
	}
	public void add(Node n, int i) throws IndexOutOfBoundsException {
		if (i > this.getLength()) 
			throw new IndexOutOfBoundsException("Index greater than the number of items in the list");
		
		this.actualNode = this.firstNode;
		
		for (int index = 1; index <= i; index++) {
			this.actualNode = this.actualNode.getNextNode();
		}
		
		this.add(n);
	}
	public void addFirst(Node n) {
		n.setNextNode(this.firstNode);
		this.setFirstNode(n);
	}
	public void addFirst(int value) {
		this.addFirst(new Node(value));
	}	
	public void addLast(Node n) {
		n.setPreviousNode(this.getLastNode());
		this.setLastNode(n);
	}
	public void addLast(int value) {
		this.addLast(new Node(value));
	}

	public void remove() {
		Node aux = this.actualNode;
		this.actualNode = this.actualNode.getNextNode();
		
		aux.getNextNode().setPreviousNode(aux.getPreviousNode());
		aux.getPreviousNode().setNextNode(aux.getNextNode());
	}
	public void remove(int i) throws IndexOutOfBoundsException{
		if (i > this.lenght) 
			throw new IndexOutOfBoundsException("Index greater than the number of items in the list");
		
		this.actualNode = this.firstNode;
		
		for(int index = 1; index <= i; index++) {
			this.actualNode = this.actualNode.getNextNode();
		}
		
		this.remove();
	}
	public void romoveFirst() {
		this.setFirstNode(this.getFirstNode().getNextNode());
	}
	public void removeLast() {
		this.setLastNode(this.getLastNode().getPreviousNode());
	}
	
	public int search(int i) throws IndexOutOfBoundsException{
		if (i > this.lenght) 
			throw new IndexOutOfBoundsException("Index greater than the number of items in the list");
		
		this.actualNode = this.firstNode;
		
		for(int index = 0; index < i; index++) {
			this.actualNode = this.actualNode.getNextNode();
		}
		
		return this.actualNode.getValue();
	}

	public void cleanList() {
		this.firstNode = null;
		this.lastNode = null;
		this.actualNode = null;
	}
	
	// ------ gets and sets
	public int getLength() {return this.lenght;} 
	
	public Node getFirstNode() {return this.firstNode;}
	public void setFirstNode(Node newFirstNode) {this.firstNode = newFirstNode;}
	
	public Node getLastNode() {return this.lastNode;}
	public void setLastNode(Node newLastNode) {this.lastNode = newLastNode;}
	
	public Node getActualNode() {return this.actualNode;}
	public void setActualNode(Node newActualNode) {this.actualNode = newActualNode;}
	
	// ------ toString and equals
	public String toString() {
		return "[length: " + this.lenght +
				"\n" + "\tfirst node: " + this.firstNode +
				"\n" + "\tlast node: " + this.lastNode +
				"]\n";
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
		if (otherObject == null) {return false;}
		if (!(otherObject instanceof DoubleLinkedList other)) {return false;}
		if (this.lenght != other.getLength()) {return false;}
		
		boolean result = false;
		int index = 0;
		
		this.actualNode = this.firstNode;
		Node otherActualNode = other.getActualNode();
		
		while (index < this.lenght && !result) {
			if (this.actualNode.getValue() != otherActualNode.getValue()) {return false;}
			
			this.actualNode = this.actualNode.getNextNode();
			otherActualNode = otherActualNode.getNextNode();
		}
		return true;
	}
}
