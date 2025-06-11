import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int l = s.length();
        Stack<Character> stack = new Stack<>();
        String str = new String(s);
        out : for (int i=0; i<l; i++) {
            stack.clear();
            if (i != 0) str = str.substring(1, l) + str.charAt(0);
            for (int j=0; j<l; j++) {
                char c = str.charAt(j);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }else if(stack.isEmpty()) continue out;
                else {
                    if (c == ')' && stack.peek() == '(') stack.pop();
                    else if (c == '}' && stack.peek() == '{') stack.pop();
                    else if (c == ']' && stack.peek() == '[') stack.pop();
                    else continue out;
                }
            }
            if (stack.isEmpty()) {
                answer+=1;
            }
            
        }
        
        return answer;
    }
}