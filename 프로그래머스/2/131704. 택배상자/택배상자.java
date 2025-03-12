import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<order.length; i++){
            while(num < order[i]) {
                stack.push(num++);
            }
            if (num == order[i]) {
                num++;
                answer++;
            }else if(!stack.isEmpty() && stack.peek()==order[i]) {
                stack.pop();
                answer++;
            }else break;
        }
        
        return answer;
    }
}