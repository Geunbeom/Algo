import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.offer(i);
        
        while (pq.peek() < K && pq.size() > 1) {
            int k = pq.poll() + pq.poll()*2;
            pq.offer(k);
            answer++;
        }
        if (pq.peek() < K && pq.size() == 1) return -1;
        return answer;
    }
}