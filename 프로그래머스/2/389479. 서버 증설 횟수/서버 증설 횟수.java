import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i=0; i<24; i++) {
            int server = players[i]/m;
            int count = 0;
            
            while(q.size() != 0 && q.peek() <= i) q.poll();
            
            while(q.size() < server) {
                q.offer(i+k);
                count += 1;
            }
            
            answer += count;
        }
        
        
        return answer;
    }
}