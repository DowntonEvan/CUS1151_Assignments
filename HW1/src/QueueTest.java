import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	/*Your functions (on the left) correspond to the following java Queue functions (on the right)
	 * toTest.enqueue(String a) = toCompare.add(String a)
	 * toTest.dequeue() = toCompare.poll()
	 * toTest.front() = toCompare.peek()
	 * 
	 * This private class performs this interface for you.
	 */
    private static class JavaQueue{
    	//DO NOT EDIT THIS CLASS
    	Queue<String> queue;
    	protected JavaQueue(){
    		queue = new LinkedList<String>();
    	}
    	protected void enqueue(String a){
    		queue.add(a);
    	}
    	protected String dequeue(){
    		return queue.poll();
    	}
    	protected String front(){
    		return queue.peek();
    	}
    }

	public static void main(String[] args){

		if(testEmpty(new ListQueue(),new JavaQueue())){ //Tests if an empty java queue is the same as our queue
			System.out.println("The two Queues are the same");
		}
		//testOne(new ListQueue(),new JavaQueue());
		//testMany(new ListQueue(),new JavaQueue());
		
	}
	
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
			if(yourQueue.front() != correctQueue.front()) { //Tests to see if the the empty queues are equal
				return false;
			}
			return true; //If the code makes it to this point then the queues were the same at all points.
	}
	
	public static boolean testOne(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have one element
		//Compare the result of your queue  against the java implementation
		return false;
	}
	
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		return false;
	}
}