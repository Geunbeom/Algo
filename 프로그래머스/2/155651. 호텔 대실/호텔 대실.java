import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int room = 0;
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        
        for (int i=0; i<book_time.length; i++) {
            String[] arr = book_time[i][0].split(":");
            start.offer(Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]));
            arr = book_time[i][1].split(":");
            end.offer(Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]) + 10);
        }
        
        while(!start.isEmpty()) {
            if (start.peek() < end.peek()) {
                start.poll();
                room++;
                answer = Math.max(room, answer);
            } else {
                end.poll();
                room--;
            }
        }
        
        
        return answer;
    }
}