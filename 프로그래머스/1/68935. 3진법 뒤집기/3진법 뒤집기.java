class Solution {
    public int solution(int n) {
        int answer = 0;
        String str1 = "";
        boolean check = false;
        for (int i=16; i>=0; i--) {
            int k = (int) Math.pow(3, i);
            if (n >= k) {
                check = true;
                str1 += n/k;
                n -= (n/k)*k;
            }else if (check) str1+=0;
        }
        for (int i=0; i<str1.length(); i++) {
            int k = str1.charAt(i) - '0';
            k *= (int) Math.pow(3, i);
            answer += k;
        }
        
        
        return answer;
    }
}