class Solution {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = ((dp[n-1] == 0 ? fibo(n-1) : dp[n-1])
            + (dp[n-2] == 0 ? fibo(n-2) : dp[n-2]))%1234567;
        return dp[n]%1234567;
    }
    
}