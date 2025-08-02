class Solution {
    int solution(int[][] land) {
        int N = land.length-1;
        for (int i=1; i<=N; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        
        return Math.max(Math.max(land[N][0], land[N][1]), Math.max(land[N][2], land[N][3]));
    }
}