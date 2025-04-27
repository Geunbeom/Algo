import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        boolean[] check = new boolean[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : reserve) check[i] = true;
        for (int i : lost) {
            if (!check[i]) {
                pq.offer(i);
                answer -= 1;
            } else check[i] = false;
        }
        
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if(i != 1 && check[i-1]) {
                answer += 1;
                check[i-1] = false;
            }else if (i != n && check[i+1]) {
                answer += 1;
                check[i+1] = false;
            }
        }
        
        return answer;
    }
}