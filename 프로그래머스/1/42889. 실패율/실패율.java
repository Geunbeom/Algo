import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long k = (long) a[2]*b[1] - (long) a[1]*b[2];
            if (k == 0) {
                return a[0]-b[0];
            }else if (k>0) return 1;
            else return -1;
        });
        int[] answer = new int[N];
        int[] count = new int[N+2];
        int L = stages.length;
        
        for (int i=0; i<L; i++) {
            count[stages[i]]++;
        }
        
        for (int i=1; i<=N; i++) {
            int[] k = new int[3];
            k[0] = i;
            k[1] = count[i];
            k[2] = L;
            L -= count[i];
            pq.offer(k);
        }
        int idx = 0;
        while(!pq.isEmpty()) {
            int[] k = pq.poll();
            answer[idx++] = k[0];
        }
        
        return answer;
    }
}