class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') answer += c;
            else if((c >= 'a' && c <= 'z')){
                if (c+n >= 'a' && c+n <= 'z') {
                    answer += (char) (c+n);
                }else {
                    answer += (char) (c+n-26);
                }
            }else {
                if (c+n >= 'A' && c+n <= 'Z') {
                    answer += (char) (c+n);
                }else {
                    answer += (char) (c+n-26);
                }
            }
            
        }
        return answer;
    }
}