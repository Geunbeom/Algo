import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int l = board.length;
        int[] n = new int[l];
        for (int r=l-1; r>=0; r--) {
            for (int c=0; c<l; c++) {
                if (board[r][c] != 0) continue;
                if (r == l-1 || n[c] != 0) continue;
                n[c] = r+1;
            }
            
        }
        
        for (int i=0; i<moves.length; i++) {
            int idx = moves[i]-1;
            if (n[idx] == l) continue;
            if (stack.isEmpty() || stack.peek() != board[n[idx]][idx]) {
                stack.push(board[n[idx]][idx]);
            }else {
                stack.pop();
                answer+=2;
            }
            n[idx]++;
        }
        
        
        return answer;
    }
}