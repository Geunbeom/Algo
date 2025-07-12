class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int L = arr1.length;
        int l = arr1[0].length;
        int l2 = arr2[0].length;
        int[][] answer = new int[L][l2];
        for (int r=0; r<L; r++) {
            for (int r2=0; r2<l2; r2++) {
                int curr = 0;
                for (int c=0; c<l; c++) {
                    curr += arr1[r][c]*arr2[c][r2];
                }
                answer[r][r2] = curr;
            }
        }
        
        return answer;
    }
}