public class ListQueue {

	private class Node{
		private String Value;
		private Node next;
		public Node (){  //Default constructor for creating a Node with *NO* values (Java was not wanting to create a default constructor here, unsure why)
		    Value = null;
		    next = null;
        }
        public Node(String setValue){ //Constructor for when a Node is created with only a value but not a next node
            Value=setValue;
            next = null;
        }
        public Node(String setValue, Node setNextNode){ //COnstructor for when a Node is created with both a value and next note in mind
            Value=setValue;
            next = setNextNode;
        }
        //Getters and Setters for a Nodes values and link to the next node
        public Node getNext() {
            return next;
        }

        public String getValue() {
            return Value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(String value) {
            Value = value;
        }
    }
	
	//Class variables here, if necessary
	private Node first = null;
	
	/**
	* Constructor for the queue
	* 
	* @param FirstVal The value of the first variable
	*/
	public ListQueue(String FirstVal){ //Default Constructor given a initial input for the first node
	Node newNode = new Node(FirstVal);
	first = newNode;
	//System.out.println(first.Value); I (Evan) commented this out, outputting the list will be done in tests
	}
	public ListQueue(){ //Default Constructor
		Node newNode = new Node();
		first = newNode;
	}
	/**
	* Adds a value to the queue
	* 
	* @param toInput the string to input
	*/
	public void enqueue(String toInput) {
	Node theNode = first;
	Node newNode = new Node(toInput);
	
	if(first == null)
	{
		first = newNode;
	}
	
	while(theNode.getNext() != null)
	{
		theNode = theNode.getNext(); //Traverses a given linked list to add newNode to the end of the given list
	}
	theNode.next = newNode;
	}
	/**
	* removes a value from the queue
	* 
	* @return the string value of the node
	*/
	public String dequeue(){
		Node theNode = first;
		if(theNode.getNext() == null)
		{
			first = null;
		}
		else
		{
			first = theNode.getNext(); //Sets the 2nd node in the queue to be the first
		}
		theNode.setNext(null); //removes the link from the first node in the queue to the rest of the queue
		theNode.setValue(null);
		return theNode.getValue();
	}
	/**
	* returns the value of the first node
	* 
	* @return the string value of the first node
	*/
	public String front(){
		if(first == null)
		{
			return "null";
		}
		return first.getValue();
	}

}