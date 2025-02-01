import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y+1];
        queue.offer(x);
        visited[x] = true;
        if (x==y)return 0;
        
        while (!queue.isEmpty()) {
            int l = queue.size();
            answer++;
            for (int i=0; i<l; i++) {
                int curr = queue.pop();
                
                int k = curr + n;
                if (k < y && !visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                }else if(k==y) return answer;
                
                k = curr*2;
                if (k < y && !visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                }else if(k==y) return answer;
                
                k = curr*3;
                if (k < y && !visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                }else if(k==y) return answer;
            }
        }
        
        
        return -1;
    }
}