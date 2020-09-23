/*
 * This class implements a queue with linked list
 * Author: Meng Yang
 * Date: Fall 2018
 */

public class LLQueueForStudents {
    // This is an inner class specifically utilized for LLStack class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {
           this.data = null;
           this.next = null;
        }

        // Parametrized constructor for inner class
        public Node(Object newData, Node nextLink) {
            // to do: Data part of Node is an Object
            // to do: Link to next node is a type Node
        	
        	this.data = newData;
        	this.next = nextLink;
        }
    }
    
    private Node front;
    private Node back;

    public LLQueueForStudents() {
     // to do
    	this.front = null;
    	this.back = null;
    }
    
    //offer(enqueue) adds the object at the back of the queue
    public void offer(Object o) {
     // to do
    	if (back == null) {
    		front = new Node(o, null);
    		back = front;
    	} else {
	    	back.next = new Node(o, null);
	    	back = back.next;
    	}
    }
    
    //poll(dequeue): retrieves and removes the head of this queue, 
    //or returns null if this queue is empty.
    public Object poll() {
     // to do
    	if (isEmpty()) return null;
    	Object out = front.data;
    	if (front.next == null) back = null;
    	front = front.next;
    	return out;
    	
    }
    
    // Returns the size of linked list by traversing the list
    public int size() {
        // to do
    	int count = 0;
    	Node place = front;
    	while (place != null) {
    		count++;
    		place = place.next;
    	}
    	return count;
    }
    //peek: Retrieves, but does not remove, the head of this queue, 
    //or returns null if this queue is empty.
    public Object peek() {
        // to do
    	if (front == null)  return null;
    	return front.data;
    } 
    
    //
    public boolean isEmpty() {
        // to do
    	return front == null;
    } 
    
    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (!(otherObject instanceof LLQueueForStudents)) {
            return false;
        } else {
            LLQueueForStudents otherList = (LLQueueForStudents) otherObject;
            if (size() != otherList.size())
                return false;
            Node position = front;
            Node otherPosition = otherList.front;
            while (position != null) {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.next;
                otherPosition = otherPosition.next;
            }
            return true; // objects are the same
        }
    }
    
    // There is no need to modify the driver
    public static void main(String[] args) {
     // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        LLQueueForStudents list = new LLQueueForStudents();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);
        
        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        
        //testing equals
        LLQueueForStudents list2 = new LLQueueForStudents();
        // add 4 objects to the new linked list
        list2.offer(object1);//t
        list2.offer(object2);//o
        list2.offer(object3);//m
        list2.offer(object4);//s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);
        
        // add 4 objects to our linked list in a different order
        LLQueueForStudents list3 = new LLQueueForStudents();
        list3.offer(object3);//m
        list3.offer(object1);//t
        list3.offer(object2);//o
        list3.offer(object4);//s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);
        
        // testing isEmpty() and poll()
        while(!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }
       
    }

   

}
