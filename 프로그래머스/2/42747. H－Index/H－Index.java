import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int L = citations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int k : citations) pq.offer(k);
        
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr >= L) {
                answer = L;
                break;
            }
            L--;
        }
        
        
        return answer;
    }
}