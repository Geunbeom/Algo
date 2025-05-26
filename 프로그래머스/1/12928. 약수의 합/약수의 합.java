class Solution {
    public int solution(int n) {
        int k = (int) Math.sqrt(n);
        int answer = 0;
        for (int i=1; i<=k; i++) {
            if (n%i == 0) {
                if (i*i != n) answer += n/i;
                answer += i;
            }
        }
        return answer;
    }
}