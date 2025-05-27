class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int max = d/k;
        for (int y=0; y<=max; y++) {
            answer += 1 + (long) Math.sqrt(((long) d*d)/((long) k*k)-((long) y*y));
        }
        return answer;
    }
}