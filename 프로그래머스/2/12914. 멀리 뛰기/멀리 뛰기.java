class Solution {
    public long solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            long k = dp[i-1] + dp[i-2];
            dp[i] = (int) (k % 1234567);
        }
        return (long) dp[n];
    }
}