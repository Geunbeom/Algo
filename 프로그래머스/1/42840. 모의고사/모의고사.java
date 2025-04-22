import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {1, 3, 4, 5};
        int[] third = {3, 1, 2, 4, 5};
        
        int f=0;
        int s=0;
        int t=0;
        int max = 0;
        
        for (int i=0; i<answers.length; i++) {
            int idx = i%5;
            if (answers[i] == first[idx]) f++;
            max = Math.max(max, f);
            
            idx = i%2;
            if (idx == 0 && answers[i] == 2) s++;
            else if (idx != 0 && answers[i]==second[(i/2)%4]) s++;
            max = Math.max(max, s);
            
            idx = (i/2)%5;
            if (answers[i] == third[idx]) t++;
            max = Math.max(max, t);
        }
        int count = 0;
        if (f == max) answer.add(1);
        if (s == max) answer.add(2);
        if (t == max) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}