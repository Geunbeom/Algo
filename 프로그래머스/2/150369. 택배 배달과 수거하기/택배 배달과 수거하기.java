import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        long todo = 0;
        long remain = 0;
        
        Deque<int[]> todoQ = new ArrayDeque<>();
        Deque<int[]> remainQ = new ArrayDeque<>();
        
        for (int i=n-1; i>=0; i--) {
            if (deliveries[i] != 0) {
                todoQ.offer(new int[] {i+1, todoQ.peekLast() == null ? deliveries[i] : todoQ.peekLast()[1] + deliveries[i]});
            }
            if (pickups[i] != 0) {
                remainQ.offer(new int[] {i+1, remainQ.peekLast() == null ? pickups[i] : remainQ.peekLast()[1] + pickups[i]});
            }
        }
        
        while(!todoQ.isEmpty() || !remainQ.isEmpty()) {
            todo += cap;
            remain += cap;
            answer += (long) Math.max(todoQ.peekFirst() == null ? 0 : todoQ.peekFirst()[0], remainQ.peekFirst() == null ? 0 : remainQ.peekFirst()[0]);
            if (!todoQ.isEmpty()) {
                while(todoQ.peekFirst() != null && todoQ.peekFirst()[1] <= todo) {
                    todoQ.poll();
                }
            }
            
            if (!remainQ.isEmpty()) {
                while(remainQ.peekFirst() != null && remainQ.peekFirst()[1] <= remain) {
                    remainQ.poll();
                }
            }
        }
        
        return answer*2;
    }
}