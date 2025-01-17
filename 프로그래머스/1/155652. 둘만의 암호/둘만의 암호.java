class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int idx = 0;
            while (idx < index) {
                c++;
                if (c > 'z') c = 'a';
                if(!skip.contains(Character.toString(c))) idx++;
            }
            answer += Character.toString(c);
        }
        
        return answer;
    }
}