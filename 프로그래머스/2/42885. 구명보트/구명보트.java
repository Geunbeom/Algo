import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int s = 0;
        int e = people.length-1;
        
        while(s <= e) {
            if(people[s] + people[e] <= limit) {
                s++;
            }
            e--;
            answer++;
        }
        
        
        return answer;
    }
}