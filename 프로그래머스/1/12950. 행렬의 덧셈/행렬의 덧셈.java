class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr1[0].length;
        int[][] answer = new int[N][M];
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }
        
        return answer;
    }
}