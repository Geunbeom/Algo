class Solution {
    
    static String bit = new String();
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (s.length() != 1) {
            answer[0]++;
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            answer[1] -= s.length();
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}