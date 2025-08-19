import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            if (i%divisor == 0) pq.offer(i);
        }
        if (pq.size() == 0) answer = new int[] {-1};
        else {
            answer = new int[pq.size()];
            for (int i=0; i<answer.length; i++) {
                answer[i] = pq.poll();
            }
        }
        return answer;
    }
}