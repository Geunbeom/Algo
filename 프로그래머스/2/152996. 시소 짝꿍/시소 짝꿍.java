import java.util.*;

class Solution {
    
    static long answer = 0;
    
    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<weights.length; i++) {
            if (map.get(weights[i]) == null) map.put(weights[i], 1);   
            else map.put(weights[i], map.get(weights[i])+1);
        }
        
        map.forEach((k, v) -> {
            answer += ((long) v * (v-1))/ (long) 2;
            if (map.get(k*2) != null) answer += (long) v*map.get(k*2);
            if (k%2 == 0 && map.get((k/2)*3) != null) answer += (long) v*map.get((k/2)*3);
            if (k%3 == 0 && map.get((k/3)*4) != null) answer += (long) v*map.get((k/3)*4);
        });
        
        
        return answer;
    }
}