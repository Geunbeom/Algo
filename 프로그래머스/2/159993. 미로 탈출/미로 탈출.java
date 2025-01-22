import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        int[] middle = new int[2];;
        for (int r=0; r<maps.length; r++) {
            for (int c=0; c<maps[0].length(); c++) {
                char curr = maps[r].charAt(c);
                if (curr == 'S') start = new int[] {r, c};
                else if (curr == 'E') end = new int[] {r, c};
                else if (curr == 'L') middle = new int[] {r, c};
            }
        }
        int k = bfs(start, middle, maps);
        int l = bfs(middle, end, maps);
        if (k == -1 || l == -1) answer = -1;
        else answer = k+l;
        return answer;
    }
    
    public int bfs(int[] start, int[] end, String[] maps) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int N = maps.length;
        int M = maps[0].length();
        int t = 0;
        boolean[][] visited = new boolean[N][M];
        
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            t++;
            int l = q.size();
            for (int j=0; j<l; j++) {
                int[] curr = q.poll();
                for (int i=0; i<4; i++) {
                    int R = curr[0] + dr[i];
                    int C = curr[1] + dc[i];
                    if (isCheck(R, C, N, M) || visited[R][C]) continue;
                    if (maps[R].charAt(C) == 'X') continue;
                    if (R == end[0] && C == end[1]) return t;
                    visited[R][C] = true;
                    q.offer(new int[] {R, C});
                }
            }
            
        }
        return -1;
    }
    
    public boolean isCheck(int r, int c, int N, int M) {
        if (r < 0 || c < 0 || r >= N || c >= M) return true;
        return false;
    }
    
    
}