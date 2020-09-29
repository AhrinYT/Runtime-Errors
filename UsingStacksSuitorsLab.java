import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 
 * Kenneth Ma, Richard Yang, Brandon Chan, Puvith Puhazholi
 * Runtime Errors
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;
	
	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}
	
	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome
			
		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");
		
		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);
		
	    recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();
		
		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
		
		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));	
		
		System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
		
		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
		
		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
	}
		
	
	
	
	public static void printReverse(String target) {
		//create a new stack
		Stack<Character> reverse = new Stack<Character>();
		//iterate over input string adn push each char onto stack
		for (int i = 0; i < target.length(); i++) {
			reverse.push(target.charAt(i));
		}
		//iterate until stack is empty, pop off char from stack and print it
		while (!reverse.isEmpty()) {
			System.out.print(reverse.pop());
		}
		//print new line so it looks good
		System.out.println();
	}
	
	public static void recPrintReverse(String target) {
		//todo
		//no base case necessary
		if (target.length() > 0) {
			//print out last character in string
			System.out.print(target.charAt(target.length() - 1));
			
			//call method on string with last character removed
			recPrintReverse(target.substring(0, target.length() - 1));
		}
		
	}
	
	public static boolean isPalindrome(String input) {
		//todo: use a stack
		//create new stack
		Stack<Character> tester = new Stack<Character>();
		
		//iterate over input string, push each char on stack
		for (int i = 0; i < input.length(); i++) {
			tester.push(input.charAt(i));
		}
		
		//create new String that is reverse of input
		String reverse = "";
		
		//append elements from stack onto reverse
		while (!tester.isEmpty()) {
			reverse += tester.pop();
		}
		
		//return whether the reverse is equal to the original; if so, it is a palindrome
		return reverse.equals(input);
	}

	public static boolean isPalindromeRec(String sentence)	{
	  	//todo
		//base case if the input is either 1 or 0, it is definitely a palindrome
		if (sentence.length() <= 1) return true;
		
		//conditional: if the first character != the last character, it is not a palindrome
		if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;
		
		//recursive case: if the first character == the last character, call the method with the parameter being the first and last letters cut off
		return isPalindrome(sentence.substring(1, sentence.length() - 1));
	}
	
	public static int findPlaceToStand(int numSuitors) {
		//todo
		//create new empty queue
		Queue<Integer> suitors = new LinkedList<Integer>();
		
		//add suitors 1 - num suitors into the queue
		for (int i = 1; i <= numSuitors; i++) {
			suitors.add(i);
		}
		
		//repreatedly add the first and second suitors to the back of the queue, and delete the third one
		while (suitors.size() > 1) {
			suitors.add(suitors.remove());
			suitors.add(suitors.remove());
			suitors.remove();
		}
		
		//return the final remaining suitor, which is where you should stand if you want to marry the princess
		return suitors.remove();
	}


	public static boolean buildThreadQueue() {	//returns true upon success
		Queue<Thread> q = new LinkedList<Thread>(); 
		
		//when our program starts up, it might create multiple threads to use
		q.add( new Thread(new UsingStacksSuitorsLab()));
		q.add( new Thread(new UsingStacksSuitorsLab()));
		q.add( new Thread(new UsingStacksSuitorsLab()));
		
		System.out.println("Initial Thread order:");
		q.toString();  
		
		//We need to iterate over our pool of threads and call start() on each one
		//Make a loop that dequeues a thread, calls start on it, and //enqueues it again
		//to do:
		//current = get a thread
		//current.start();
		//put the thread back
		
		System.out.println("Thread order after start()ing:");
		q.toString();  
		
		return true;  //on successful start
	}
	
	
	/*
	 * No need to edit anything below here, 
	 * unless you'd like to change the 
	 * behaviour of each thread in the thread pool above
	 */
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				//do nothing here
			}
		}
	}
}


