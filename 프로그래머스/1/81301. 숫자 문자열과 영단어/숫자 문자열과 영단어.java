import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        HashMap<String, Character> map = new HashMap<>();
        map.put("zero", '0');
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
        
        
        String t = "";
        for (int j=0; j<s.length(); j++) {
            char k = s.charAt(j);
            if (k >= '0' && k <= '9') {
                answer += k;
                continue;
            }
            t += k;
            if (map.get(t) != null) {
                answer += map.get(t);
                t = "";
            }
        }
        
        return Integer.parseInt(answer);
    }
}