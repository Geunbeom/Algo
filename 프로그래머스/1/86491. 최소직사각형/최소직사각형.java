class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int i=0; i<sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                max = Math.max(max, sizes[i][1]);
                min = Math.max(min, sizes[i][0]);
            }else {
                max = Math.max(max, sizes[i][0]);
                min = Math.max(min, sizes[i][1]);
            }
        }
        
        
        return max*min;
    }
}