import java.util.*;
class Solution {
    public String solution(String s) {
        String answe = "";
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {return b-a;});
        for (int i=0; i<s.length(); i++) pq.offer(s.charAt(i));
        while(!pq.isEmpty()) answe += pq.poll();
        return answe;
    }
}