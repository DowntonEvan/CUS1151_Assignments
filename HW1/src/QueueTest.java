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

    	//Both queues are empty
		System.out.println("EMPTY QUEUE TEST");
		if(testEmpty(new ListQueue(),new JavaQueue())){ //Tests if an empty java queue is the same as our queue
			System.out.println("The two Queues are the same");
		}

		//Both queues starting with 1 element
		ListQueue q = new ListQueue("Zeta");
		JavaQueue j = new JavaQueue();
		j.enqueue("Zeta");

		System.out.println("ONE ELEMENT QUEUE TEST");
		if(testOne(q, j))
			System.out.println("Both Queues are the same.");
		else
			System.out.println("Both Queues are not the same.");

		//testMany(new ListQueue(),new JavaQueue());
		
	}
	
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
			if(yourQueue.front() != correctQueue.front()) { //Tests to see if the the empty queues are equal
				return false;
			}
			return true; //If the code makes it to this point then the queues were the same at all points.
	}
	
	public static boolean testOne(ListQueue a, JavaQueue b){
		//Test each of the 3 functions (enqueue, dequeue, front)
		//System.out.println(b.queue.size());
		if(a.first == a.last && b.queue.size() == 1){	//If the ListQueue has 1 element [First & Last Nodes are the Same]
			a.enqueue("Test");					//And the JavaQueue has 1 element [Queue Size Method]
			b.enqueue("Test");					//Testing if .enqueue() works
			if(a.front() == b.front()){				//Testing if enqueue values are the same & .front() works
				if(a.dequeue() == b.dequeue())	{	//Testing if dequeue values are the same & .dequeue() works
					if(a.front() == b.front()){		//Testing if .front() values for both queues are the same at the end
						return true;				//All 3 functions work + Both Queues contain only 1 element
					}
				}
			}
		}
		return false;
	}
	
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		return false;
	}
}