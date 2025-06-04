class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int idx = 0;
        while(str.length() < t*m) {
            str += Integer.toString(idx++, n);
        }
        for (int i=0; i<t; i++) {
            char c = str.charAt(i*m+p-1);
            answer += c <= '9' ? c : (char) (c-32);
        }
        return answer;
    }
}