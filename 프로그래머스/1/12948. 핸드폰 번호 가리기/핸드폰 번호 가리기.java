class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int l = phone_number.length();
        for (int i=0; i<l; i++) {
            if (i < l-4) answer += "*";
            else answer += phone_number.charAt(i);
        }
        return answer;
    }
}