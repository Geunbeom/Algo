import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> start = new LinkedList<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        int front = 0;
        int back = 0;
        
        for (int i=0; i<topping.length; i++) {
            if (!set.contains(topping[i])) {
                set.add(topping[i]);
                start.offer(i);
            }
            end.put(topping[i], i);
        }
        back = set.size();
        for (int i=0; i<topping.length; i++) {
            while (!start.isEmpty() && start.peek() <= i) {
                front += 1;
                start.poll();
            }
            if (end.get(topping[i]) == i) back-=1;
            if (front == back) answer += 1;
        }
        
        
        return answer;
    }
}