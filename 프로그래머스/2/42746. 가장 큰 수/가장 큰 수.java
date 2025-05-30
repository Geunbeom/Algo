import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        for (int i : numbers) pq.offer(Integer.toString(i));
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}