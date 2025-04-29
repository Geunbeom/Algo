import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        Arrays.sort(d);
        for (int i=0; i<d.length; i++) {
            budget -= d[i];
            if (budget < 0) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}