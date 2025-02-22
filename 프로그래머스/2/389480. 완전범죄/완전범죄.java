import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if ((a[1]-a[0]) != b[1]-b[0]) return (a[1]-a[0]) - (b[1]-b[0]);
            else return b[1]-a[1];
        });
        
        for (int i=0; i<info.length; i++) pq.offer(info[i]);
        
        int a = 0;
        int b = 0;
        while(!pq.isEmpty()) {
            if (b+pq.peek()[1] < m) b += pq.peek()[1];
            else if (a + pq.peek()[0] < n) a += pq.peek()[0];
            else break;
            pq.poll();
        }
        
        return pq.isEmpty() ? a : -1;
    }
}