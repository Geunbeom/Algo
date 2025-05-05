class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int k = (brown+4)/2;
        int t = (int) Math.sqrt(k*k - (4*(brown + yellow)));
        if (t < 0) t = -t;
        answer[0] = (k+t)/2;
        answer[1] = k-answer[0];
        
        if (answer[0] < answer[1]) {
            t = answer[1];
            answer[1] = answer[0];
            answer[0] = t;
        }
        
        return answer;
    }
}