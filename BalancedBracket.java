import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedBracket {
	public static void main(String[] args) {
		// insert test cases
		String[] test = { "}][}}(}][))]", "{}[]()", "{{()" };
		System.out.println(Arrays.toString(braces(test)));
	}
	
	static String[] braces(String[] values) {
        
        String[] sol = new String[values.length];
        
        for (int i = 0; i < values.length; i++) {
            Stack<Character> s = new Stack<Character>();
            Queue<Character> q = new LinkedList<Character>();
            for (int j = 0; j < values[i].length(); j++) q.add(values[i].charAt(j));
            
            while (!q.isEmpty()) {
                if ((q.peek() == '[' || q.peek() == '{') || q.peek() == '(') {
                    s.push(q.remove());
                } else if (!s.isEmpty()) {
                    char left = s.pop();
                    char right = q.remove();
                        
                    if (left == '[' && right != ']') {
                        sol[i] = "NO";
                        break;
                    } else if (left == '{' && right != '}') {
                        sol[i] = "NO";
                        break;
                    } else if (left == '(' && right != ')') {
                        sol[i] = "NO";
                        break;
                    }
                } else {
                    sol[i] = "NO";
                    break;
                }
                
            }
            if (!s.isEmpty()) sol[i] = "NO";
            if (sol[i] == null) sol[i] = "YES";
        }
        
        return sol;
    }
}
    
