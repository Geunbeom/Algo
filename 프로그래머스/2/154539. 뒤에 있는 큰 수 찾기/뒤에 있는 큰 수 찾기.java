import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for (int i=numbers.length-1; i>=0; i--) {
            if (max <= numbers[i]) answer[i] = -1;
            else {
                while(true) {
                    if (stack.peek() > numbers[i]) {
                        answer[i] = stack.peek();
                        break;
                    }else stack.pop();
                }
            }
            stack.push(numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        
        return answer;
    }
}