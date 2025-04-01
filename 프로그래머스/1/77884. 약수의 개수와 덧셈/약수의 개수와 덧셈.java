class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            int sq = (int) Math.sqrt(i);
            if (sq*sq == i) answer -= i;
            else answer += i;
        }
        
        return answer;
    }
    
}