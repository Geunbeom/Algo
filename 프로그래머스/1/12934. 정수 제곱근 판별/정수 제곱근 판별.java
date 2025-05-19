class Solution {
    public long solution(long n) {
        long k = (long) Math.sqrt(n);
        return k*k==n?((k+1)*(k+1)):-1;
    }
}