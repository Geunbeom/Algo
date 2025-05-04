class Solution {

    static int answer, t;
    static int[] nbs;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        nbs = numbers;
        t = target;
        combination(0, 0);
        return answer;
    }
    
    static void combination(int n, int tg) {
        if (n == nbs.length) {
            if (t == tg) answer += 1;
            return;
        }
        combination(n+1, tg+(nbs[n]));
        combination(n+1, tg-(nbs[n]));
    }
    
}