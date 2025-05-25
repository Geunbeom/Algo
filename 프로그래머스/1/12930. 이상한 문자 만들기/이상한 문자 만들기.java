class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        int idx = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += c;
                idx = 0;
            }else {
                if (idx%2 == 0) answer += (char) (c-32);
                else answer += c;
                idx++;
            }
        }
        return answer;
    }
}