class Solution {
    public long solution(int w, int h) {
        long answer = (long) w*h;
        long k = getGCD(w, h);
        
        return answer-((long) w+h-k);
    }
    
    public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a%b);
    }
}