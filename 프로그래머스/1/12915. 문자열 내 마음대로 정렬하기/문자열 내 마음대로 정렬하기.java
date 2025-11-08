import java.util.*;

class Solution {
    
    static int N;
    public String[] solution(String[] strings, int n) {
        N = n;
        int l = strings.length;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            char c1 = a.charAt(N);
            char c2 = b.charAt(N);
            if (c1 == c2) {
                return a.compareTo(b);
            }
            return a.charAt(N)-b.charAt(N);
        });
        for (int i=0; i<l; i++) {
            pq.offer(strings[i]);
        }
        String[] answer = new String[l];
        for (int i=0; i<l; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}