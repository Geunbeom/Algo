import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "";
        
        for (int i=0; i<survey.length; i++) {
            if (choices[i] == 4) continue;
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            if (choices[i] < 4) {
                map.put(a, map.get(a) == null ?
                    (4-choices[i]) : (map.get(a)+(4-choices[i])));
            } else {
                map.put(b, map.get(b) == null ?
                    (choices[i]-4) : (map.get(b)+(choices[i]-4)));
            }
            
        }
        
        if ((map.get('R') == null ? 0 : map.get('R'))
            < (map.get('T') == null ? 0 : map.get('T'))) answer += "T";
        else if((map.get('R') == null ? 0 : map.get('R'))
            > (map.get('T') == null ? 0 : map.get('T'))) answer += "R";
        else answer += "R";
            
        if ((map.get('F') == null ? 0 : map.get('F'))
            < (map.get('C') == null ? 0 : map.get('C'))) answer += "C";
        else if((map.get('F') == null ? 0 : map.get('F'))
            > (map.get('C') == null ? 0 : map.get('C'))) answer += "F";
        else answer += "C";
        
        if ((map.get('M') == null ? 0 : map.get('M'))
            < (map.get('J') == null ? 0 : map.get('J'))) answer += "J";
        else if((map.get('M') == null ? 0 : map.get('M'))
            > (map.get('J') == null ? 0 : map.get('J'))) answer += "M";
        else answer += "J";
        
        if ((map.get('A') == null ? 0 : map.get('A'))
            < (map.get('N') == null ? 0 : map.get('N'))) answer += "N";
        else if((map.get('A') == null ? 0 : map.get('A'))
            > (map.get('N') == null ? 0 : map.get('N'))) answer += "A";
        else answer += "A";
        
        return answer;
    }
}