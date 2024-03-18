import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
		
		
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		String ans = "";
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
				ans+=c;
				
			}else if (c=='(') {	
				stack.add(c);
				
			}else if(c == ')') {
				while (stack.peek() != '(') {
					ans+=stack.pop();
				}
				stack.pop();
				
			}else if (stack.isEmpty()){
				stack.add(c);
				
			}else if(map.get(stack.peek()) >= map.get(c)) {
				while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
					ans+=stack.pop();
				}
				stack.add(c);
				
			}else {
				stack.add(c);
			}
			
		}
		while (!stack.isEmpty()) {
			ans+=stack.pop();
		}
		
		System.out.println(ans);
		
		
		
	}
}
