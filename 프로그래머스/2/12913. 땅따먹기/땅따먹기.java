class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        boolean check = false;
        int[] dp1 = new int[4];
        int[] dp2 = new int[4];
        
        for (int i=0; i<N; i++) {
            if (check) func(dp1, dp2, land[i]);
            else func(dp2, dp1, land[i]);
            check = !check;
        }
        if (check)
            return Math.max(Math.max(dp1[0], dp1[1]), Math.max(dp1[2], dp1[3]));
        else return Math.max(Math.max(dp2[0], dp2[1]), Math.max(dp2[2], dp2[3]));
    }
    
    void func(int[] prev, int[] next, int[] land) {
        next[0] = Math.max(Math.max(prev[1], prev[2]), prev[3]) + land[0];
        next[1] = Math.max(Math.max(prev[0], prev[2]), prev[3]) + land[1];
        next[2] = Math.max(Math.max(prev[0], prev[1]), prev[3]) + land[2];
        next[3] = Math.max(Math.max(prev[0], prev[1]), prev[2]) + land[3];
    }


}