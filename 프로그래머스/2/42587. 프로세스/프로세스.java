import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        LinkedList<int[]> q = new LinkedList<>();
        int answer = 0;
        
        for (int i=0; i<priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        while (true) {
            int k = pq.poll();
            while(q.peek()[1] != k) {
                q.offer(q.poll());
            }
            answer++;
            if (q.poll()[0] == location) break;
        }
        return answer;
    }
}