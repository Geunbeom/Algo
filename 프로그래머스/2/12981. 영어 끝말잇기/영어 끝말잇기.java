import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};
        HashSet<String> set = new HashSet<>();
        char last = words[0].charAt(0);
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (set.contains(word) || last != word.charAt(0)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            }
            set.add(word);
            last = word.charAt(word.length()-1);
        }
        
        return answer;
    }
}