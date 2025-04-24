import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0 ; i<commands.length; i++) {
            for (int j=commands[i][0]-1; j<commands[i][1]; j++) {
                pq.offer(array[j]);
            }
            int index = 1;
            while (!pq.isEmpty()) {
                if (index == commands[i][2]) {
                    answer[i] = pq.poll();
                }else pq.poll();
                index++;
            }
            
        }
        
        return answer;
    }
}