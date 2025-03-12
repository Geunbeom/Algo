import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        boolean isClear = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        
        for (int i=0; i<enemy.length; i++) {
            answer = i;
            pq.offer(enemy[i]);
            n -= enemy[i];
            if(n < 0) {
                if (k==0) {
                    isClear = false;
                    break;
                } else {
                    n += pq.poll();
                    k--;
                }
            }
        }
        return isClear ? answer+1 : answer;
    }
}