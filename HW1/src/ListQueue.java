public class ListQueue {

    private class Node {
        String value;
        Node next;

        public Node() {  //Default constructor for creating a Node with *NO* values (Java was not wanting to create a default constructor here, unsure why)
            value = null;
            next = null;
        }

        public Node(String setValue) { //Constructor for when a Node is created with only a value but not a next node
            value = setValue;
            next = null;
        }

        public Node(String setValue, Node setNextNode) { //Constructor for when a Node is created with both a value and next note in mind
            value = setValue;
            next = setNextNode;
        }

        //Getters and Setters for a Nodes values and link to the next node
        public Node getNext() {
            return next;
        }

        public String getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(String value) {
            value = value;
        }
    }

    //Class variables here, if necessary
    Node first;
    Node last;

    /**
     * Constructor for the queue
     *
     * @param FirstVal The value of the first variable
     */
    public ListQueue(String FirstVal) { //Default Constructor given a initial input for the first node
        Node newNode = new Node(FirstVal);
        first = newNode;
        last = newNode;
        //System.out.println(first.Value); I (Evan) commented this out, outputting the list will be done in tests
    }

    public ListQueue() { //Default Constructor, Queue Starts Empty
        first = null;
        last = null;
    }

    /**
     * Adds a value to the queue
     *
     * @param toInput the string to input
     */
    public void enqueue(String toInput) {
        Node newNode = new Node(toInput);

        if (first == null) {    //If the queue is empty
            first = newNode;
            last = newNode;
        } else {                    //If the queue has 1+ elements
            last.setNext(newNode);
            last = newNode;
        }

    }

    /**
     * removes a value from the queue
     *
     * @return the string value of the node
     */
    public String dequeue() {
        Node theNode = first;
        if (first == null) {        //If Queue Is Empty
            return null; //Return null
        } else {
            first = first.next;            //2nd node in Queue becomes the 1st node
            return theNode.getValue();    //Returns the dequeued node
            //first = theNode.getNext(); //Sets the 2nd node in the queue to be the first
        }
        //theNode.setNext(null); //removes the link from the first node in the queue to the rest of the queue
        //theNode.setValue(null);
        //return theNode.getValue();
    }

    /**
     * returns the value of the first node
     *
     * @return the string value of the first node
     */
    public String front() {
        if (first == null) {
            return null;
        }
        return first.getValue();
    }

}