class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int y=0; y<=r2; y++) {
            int x2 = (int) Math.sqrt((long) r2*r2 - (long) y*y);
            int x1 = (int) Math.sqrt((long) r1*r1 - (long)y*y);
            if ((long) x1*x1+ (long) y*y == (long) r1*r1) x1-=1;
            answer += (x2 - (x1 < 0 ? 0 : x1));
        }
            
        return answer*4;
    }
}