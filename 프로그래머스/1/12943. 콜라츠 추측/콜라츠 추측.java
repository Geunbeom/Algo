class Solution {
    public int solution(int num) {
        int answer = 0;
        long k = (long) num;
        if (num == 1) return 0;
        
        while (true) {
            answer++;
            if (k%2==0)k = (long) k/2;
            else k = (long) k*3+1;
            
            if (answer == 500 || k == 1) break;
        }
        return answer == 500 ? -1 : answer;
    }
}