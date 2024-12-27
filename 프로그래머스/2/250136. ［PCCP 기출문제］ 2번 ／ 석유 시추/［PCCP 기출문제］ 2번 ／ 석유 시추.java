import java.util.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 2;
        for (int r=0; r<land.length; r++) {
            for (int c=0; c<land[0].length; c++) {
                if (land[r][c] == 1) {
                    list.add(bfs(land, visited, new int[] {r, c}, idx));
                    idx++;
                }
            }
        }
        
        for (int c=0; c<land[0].length; c++) {
            boolean[] check = new boolean[list.size()];
            int t = 0;
            for (int r=0; r<land.length; r++) {
                if (land[r][c] == 0) continue;
                if (check[land[r][c]-2]) continue;
                t += list.get(land[r][c]-2);
                check[land[r][c]-2] = true;
            }
            answer = Math.max(t, answer);
        }
        
        
        return answer;
    }
    
    static public int bfs(int[][] land, boolean[][] visited, int[] start, int idx) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        land[start[0]][start[1]] = idx;
        int count = 1;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i=0; i<4; i++) {
                int R = curr[0] + dr[i];
                int C = curr[1] + dc[i];
                
                if (R < 0 || C < 0 || R >= land.length || C >= land[0].length) continue;
                if (visited[R][C] || land[R][C] == 0) continue;
                
                queue.offer(new int[] {R, C});
                visited[R][C] = true;
                land[R][C] = idx;
                count++;
            }
        }
        return count;
    }
    
}