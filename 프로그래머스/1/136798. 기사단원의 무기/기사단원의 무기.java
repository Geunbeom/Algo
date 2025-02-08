class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            int k = 0;
            int sqrt = (int) Math.round(Math.sqrt(i));
            for (int j=1; j<=sqrt; j++) {
                if (i%j == 0) k+=2;
            }
            if (sqrt*sqrt == i) k--;
            if (k > limit) answer += power;
            else answer += k;
        }
        
        return answer;
    }
}