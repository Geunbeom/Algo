import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static LinkedList<int[]> q;
    static int N, M;
    static int[] start, end;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        q = new LinkedList<>();
        start = new int[2];
        end = new int[2];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    start[0] = i;
                    start[1] = j;
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }else if (c == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int answer = playing(board);
        
        return answer;
    }
    
    static int playing(String[] board) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        int count = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int t=0; t<l; t++) {
                int[] curr = q.poll();
                
                for (int i=0; i<4; i++) {
                    int R = curr[0];
                    int C = curr[1];
                    while(true) {
                        R += dr[i];
                        C += dc[i];
                        if (R < 0 || R >= N || C < 0 || C >= M || board[R].charAt(C) == 'D') {
                            R -= dr[i];
                            C -= dc[i];
                            break;
                        }
                    }
                    if (visited[R][C]) continue;
                    if (end[0] == R && end[1] == C) {
                        return count+1;
                    }
                    q.offer(new int[] {R, C});
                    visited[R][C] = true;
                }
            }

            count++;
        }
        return -1;
    }
    
}