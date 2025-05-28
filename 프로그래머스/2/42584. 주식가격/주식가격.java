import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        Stack <Integer> stack = new Stack<>();
        
        for (int i=0; i<l; i++) {
            answer[i] = l-i-1;
            if (stack.isEmpty()) stack.push(i);
            else {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(i);
                        break;
                    }
                    int idx = stack.peek();

                    if (prices[i] >= prices[idx]) {
                        stack.push(i);
                        break;
                    }
                    
                    stack.pop();
                    answer[idx] = i-idx;
                }
            }
        }
        return answer;
    }
}