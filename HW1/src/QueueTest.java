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
    private static class JavaQueue {
        //DO NOT EDIT THIS CLASS
        Queue<String> queue;

        protected JavaQueue() {
            queue = new LinkedList<String>();
        }

        protected void enqueue(String a) {
            queue.add(a);
        }

        protected String dequeue() {
            return queue.poll();
        }

        protected String front() {
            return queue.peek();
        }
    }

    public static void main(String[] args) {

        //Both queues are empty
        System.out.println("EMPTY QUEUE TEST");
        testEmpty(new ListQueue(), new JavaQueue()); //Tests if an empty java queue is the same as our queue

        //Both queues starting with 1 element
        ListQueue list = new ListQueue("Zeta");
        JavaQueue java = new JavaQueue();
        java.enqueue("Zeta");

        System.out.println("\nONE ELEMENT QUEUE TEST");
        testOne(list, java);

        System.out.println("\nMANY ELEMENT QUEUE TEST");
        ListQueue list2 = new ListQueue("Demo");
        JavaQueue java2 = new JavaQueue();
        java2.enqueue("Demo");
        list2.enqueue("Demo2");
        java2.enqueue("Demo2");
        list2.enqueue("Demo3");
        java2.enqueue("Demo3");
        testMany(list2 ,java2);

    }

    public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue) {
        if (yourQueue.front() != correctQueue.front()) { //Tests to see if the the empty queues are equal
            System.out.println("Both queues are not the same");
            return false;
        }
        yourQueue.enqueue("test");              //Tests to see if queues remain the same even after insertion
        correctQueue.enqueue("test");               //Effectively this is here to test enqueue and dequeue methods
        if(yourQueue.dequeue() != correctQueue.dequeue()){
            System.out.println("Both queues are not the same");
            return false;
        }
        System.out.println("The two Queues are the same"); //reports that the two queues were found to be the same before returning from the method back to main
        return true; //If the code makes it to this point then the queues were the same at all points.
    }

    public static boolean testOne(ListQueue a, JavaQueue b) {
        //Test each of the 3 functions (enqueue, dequeue, front)
        //System.out.println(b.queue.size());
        if (a.first != a.last || b.queue.size() != 1) {    //If the ListQueue has 1 element [First & Last Nodes are the Same]
            System.out.println("Both queues do not contain exactly 1 element.");
            return false;                                 //And the JavaQueue has 1 element [Queue Size Method]
        }
        a.enqueue("Test");
        b.enqueue("Test");                    //Testing if .enqueue() works
        if (a.front() == b.front()) {                //Testing if enqueue values are the same & .front() works
            if (a.dequeue() == b.dequeue()) {    //Testing if dequeue values are the same & .dequeue() works
                if (a.front() == b.front()) {        //Testing if .front() values for both queues are the same at the end
                    System.out.println("Both Queues are the same.");
                    return true;                //All 3 functions work + Both Queues contain only 1 element
                }
            }
        }
        System.out.println("Both Queues are not the same");
        return false;
    }

    public static boolean testMany(ListQueue a, JavaQueue b) {
        a.enqueue("Demo4"); //These two lines serve to test the enqueue function
        b.enqueue("Demo4"); //Both queues are now set up and can be tested

        while(a.front() != null){ //This loop checks to make sure that all the contents of the two arrays match
            if(b.front() == null){ //If b's front returns a null value it means the length of the two queues are different and therefore are not the same
                System.out.println("The queues are not the same"); //Placing this check before the next prevents an error form being thrown from trying to dequeue a non existent value
                return false;
            }
            if(a.dequeue() != b.dequeue()){ //If the contents of the first value in each queue are different than they are not the same and the method returns
                System.out.println("The queues are not the same");
                return false;
            }
        }

        if(b.front() != null){ //If there is still a value in B after clearing out A than B has a different length than A and is inherently different and not the same
            System.out.println("The two queues are not the same");
            return false;
        }

        System.out.println("The two queues are the same");//The the program makes it to this point without returning then the two queues must be the same
        return true;
    }
}