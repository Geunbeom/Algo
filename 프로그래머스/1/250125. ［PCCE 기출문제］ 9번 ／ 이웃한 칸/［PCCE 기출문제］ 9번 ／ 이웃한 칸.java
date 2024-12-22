class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int l = board.length;
        int[] dh = {1, -1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        
        for (int i=0; i<4; i++) {
            int H = h + dh[i];
            int W = w + dw[i];
            if (0 > H || 0 > W || l <= H || l <= W) continue;
            if (board[h][w].equals(board[H][W])) answer++;
            
            
        }
        
        
        return answer;
    }
}