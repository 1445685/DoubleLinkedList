package doubleLinkedList;

public class DoubleLinkedList {
	private int lenght = 0;
	private Node firstNode = null;
	private Node lastNode = null;
	private Node actualNode = null;
	private boolean nextNodeChecked = false;

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
	// +++++++++ adds
	public void add(Node newNode) {
		newNode.setNextNode(this.actualNode.getNextNode());
		this.actualNode.setNextNode(newNode);
	}
	public void add(int value) {
		this.add(new Node(value));
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

	// +++++++++ removes
	public void remove() {
		Node aux = this.actualNode;
		this.actualNode = this.actualNode.getNextNode();
		
		aux.getNextNode().setPreviousNode(aux.getPreviousNode());
		aux.getPreviousNode().setNextNode(aux.getNextNode());
	}
	public void romoveFirst() {
		this.setFirstNode(this.getFirstNode().getNextNode());
	}
	public void removeLast() {
		this.setLastNode(this.getLastNode().getPreviousNode());
	}

	// +++++++++ modifies
	public void modify(int newValue) {
		this.actualNode.setValue(newValue);
	}
	public void modifyFirst(int newValue) {
		this.firstNode.setValue(newValue);
	}
	public void modifyLast(int newValue) {
		this.lastNode.setValue(newValue);
	}
	
	// +++++++++ clean
	public void cleanList() {
		this.firstNode = null;
		this.lastNode = null;
		this.actualNode = null;
	}
	
	// ------ Iterator pseudo-implementation
	// TODO improve and complete implementation of iterator
	public boolean hasNext() {
		this.nextNodeChecked = true;
		return this.actualNode.getNextNode() == null;
	}
	public Node nextNode() {
		this.nextNodeChecked = false;
		return this.actualNode = this.actualNode.getNextNode();
	}
	
	// ------ gets and sets
	public int getLength() {return this.lenght;} 
	
	public Node getFirstNode() {return this.firstNode;}
	public void setFirstNode(Node newFirstNode) {this.firstNode = newFirstNode;}
	
	public Node getLastNode() {return this.lastNode;}
	public void setLastNode(Node newLastNode) {this.lastNode = newLastNode;}
	
	public Node getActualNode() {return this.actualNode;}
	public void setActualNode(Node newActualNode) {this.actualNode = newActualNode;}
	
	public boolean getNextNodeChecked() {return this.nextNodeChecked;} 
	
	// ------ toString and equals
	public String toString() {
		return "[length: " + this.lenght +
				"\n" + "\tfirst node: " + this.firstNode +
				"\n" + "\tlast node: " + this.lastNode +
				"]\n";
	}
	// TODO Finish equals method
	/*
	public boolean equals(Object otherObject) {
		if (this == otherObject) {return true;}
		if (otherObject == null) {return false;}
		if (!(otherObject instanceof DoubleLinkedList other)) {return false;}
		
		
	}
	*/
}
