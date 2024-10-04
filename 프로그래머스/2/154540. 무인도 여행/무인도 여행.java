import java.io.*;
import java.util.*;

class Solution {
    static int R;
    static int C;
    public int[] solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        boolean[][] visited = new boolean[R][C];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                char now = maps[r].charAt(c);
                if (now == 'X' || visited[r][c])
                    continue;
                pq.offer(bfs(maps, visited, r, c));
                
            }
        }
        int l = pq.size();
        if (l == 0) {
            return new int[] {-1};
        }
        int[] answer = new int[l];
        for (int i=0; i<l; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
    
    public static int bfs(String[] maps, boolean[][] visited, int r, int c) {
        int sum = maps[r].charAt(c)-'0';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            int nowR = q.peek()[0];
            int nowC = q.poll()[1];
            
            if (nowR+1 < R && !visited[nowR+1][nowC] && maps[nowR+1].charAt(nowC) != 'X') {
                sum += maps[nowR+1].charAt(nowC)-'0';
                visited[nowR+1][nowC] = true;
                q.offer(new int[] {nowR+1, nowC});
            }
            if (nowR-1 >= 0 && !visited[nowR-1][nowC] && maps[nowR-1].charAt(nowC) != 'X') {
                sum += maps[nowR-1].charAt(nowC)-'0';
                visited[nowR-1][nowC] = true;
                q.offer(new int[] {nowR-1, nowC});
            }
            if (nowC+1 < C && !visited[nowR][nowC+1] && maps[nowR].charAt(nowC+1) != 'X') {
                sum += maps[nowR].charAt(nowC+1)-'0';
                visited[nowR][nowC+1] = true;
                q.offer(new int[] {nowR, nowC+1});
            }
            if (nowC-1 >= 0 && !visited[nowR][nowC-1] && maps[nowR].charAt(nowC-1) != 'X') {
                sum += maps[nowR].charAt(nowC-1)-'0';
                visited[nowR][nowC-1] = true;
                q.offer(new int[] {nowR, nowC-1});
            }
            
        }
        return sum;
    }
    
}