import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i=0; i<speeds.length; i++) {
            int k = 100-progresses[i];
            k = k/speeds[i] + (k%speeds[i] == 0 ? 0 : 1);
            q.offer(k);
        }
        
        int count = 0;
        int max = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            if (max >= curr)count++;
            else {
                max = curr;
                if (count != 0) answer.add(count);
                count = 1;
            }
        }
        answer.add(count);
        int[] arr = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        
        return arr;
    }
}