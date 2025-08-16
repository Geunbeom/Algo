import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        LinkedList<int[]> q = new LinkedList<>();
        int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {1, -1, 0, 0};
        int count = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        int[] start = new int[] {0, 0};
        int[] end = new int[] {maps.length-1, maps[0].length-1};
        q.offer(start);
        maps[0][0] = 0;
        
        while (!q.isEmpty()) {
            count++;
            int l = q.size();
            
            for (int t=0; t<l; t++) {
                int[] curr = q.poll();
                if (curr[0] == N-1 && curr[1] == M-1) return count;
                
                for (int i=0; i<4; i++) {
                    int R = curr[0] + dr[i];
                    int C = curr[1] + dc[i];
                    if (R < 0 || C < 0 || R >= N || C >= M || maps[R][C] == 0)
                        continue;
                    q.offer(new int[]{R, C});
                    maps[R][C] = 0;
                }
                
            }
            
        }
        
        return -1;
    }
    
    
}