class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') isFirst = true;
            else if (c >= '0' && c <= '9') {
                if (isFirst) isFirst = false;
            }else {
                if (isFirst) c = c < 'a' ? c : (char) (c-32);
                else c = c >= 'a' ? c : (char) (c+32);
                isFirst = false;
            }
            answer += c;
        }
        return answer;
    }
}