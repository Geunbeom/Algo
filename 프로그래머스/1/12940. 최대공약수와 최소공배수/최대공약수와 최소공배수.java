class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = div(n, m);
        answer[1] = n*m/answer[0];
        return answer;
    }
    
    public int div(int a, int b) {
        return b==0?a:div(b, a%b);
    }
}