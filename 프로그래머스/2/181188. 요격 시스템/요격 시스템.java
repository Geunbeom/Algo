import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        
        int min = Integer.MAX_VALUE;
        int answer = 1;
        for (int i=0; i<targets.length; i++) {
            pq.offer(targets[i]);
        }
        
        int max = 0;
        while(!pq.isEmpty()) {
            if (pq.peek()[0] < min) {
                min = Math.min(pq.poll()[1], min);
            } else {
                answer+=1;
                min = pq.poll()[1];
            }
        }
        return answer;
    }
}