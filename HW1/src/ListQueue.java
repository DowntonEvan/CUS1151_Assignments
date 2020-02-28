package cus1151_hm1;


public class ListQueue {

	private class Node{
		public String Value = null;
		public Node next = null;
        public Node(String setValue){
            Value=setValue;
        }
        public Node(String setValue, Node setNextNode){
            Value=setValue;
            next = setNextNode;
            ejfpsdj
        }
		//TODO Implement Linked List Node; DONE
	}
	
	//Class variables here, if necessary
	private Node first = null;
	
	/**
	* Constructor for the queue
	* 
	* @param FirstVal The value of the first variable
	*/
	public ListQueue(String FirstVal){
	Node newNode = new Node();
	newNode.Value = FirstVal;
	first = newNode;
	System.out.println(first.Value);
	}
	/**
	* Adds a value to the queue
	* 
	* @param toInput the string to input
	*/
	public void enqueue(String toInput) {
	Node theNode = first;
	Node newNode = new Node();
	newNode.Value = toInput;
	
	if(first == null)
	{
		first = newNode;
		return;
	}
	
	while(theNode.next != null) 
	{
		theNode = theNode.next;
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
		if(theNode.next == null)
		{
			first = null;
		}
		else
		{
			first = theNode.next;
		}
		theNode.next = null;
		return theNode.Value;
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
		return first.Value;
	}

}