import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i : ingredient) {
            switch(i) {
                case 1 :
                    if (stack.isEmpty() || stack.peek() != 3)
                        stack.add(1);
                    else {
                        stack.pop();
                        answer++;
                    }
                    break;
                case 2 :
                    if (!stack.isEmpty() && stack.peek() == 1) {
                        stack.add(stack.pop()+1);
                    }else stack.add(0);
                    break;  
                case 3 :
                    if (!stack.isEmpty() && stack.peek() == 2) {
                        stack.add(stack.pop()+1);
                    }else stack.add(0);
                    break;
            }
        }
        
        return answer;
    }
}