import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static int answer;
    static int[] dr = new int[] {0, 0, -1, 1};
    static int[] dc = new int[] {1, -1, 0, 0};


    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = 0;

        for (int r=0; r<N; r++) {
            String str = br.readLine();
            for (int c=0; c<M; c++) {
                arr[r][c] = str.charAt(c) - '0';
            }
        }
    }

    static void play() {
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int l = q.size();
            answer += 1;
            for (int i=0; i<l; i++) {
                int[] curr = q.poll();
                for (int t=0; t<4; t++) {
                    int R = dr[t] + curr[0];
                    int C = dc[t] + curr[1];
                    if (R<0 || C < 0 || R >= N || C >= M || visited[R][C] || arr[R][C] == 0) continue;
                    if (R == N-1 && C == M-1) {
                        answer += 1;
                        return;
                    }
                    q.offer(new int[] {R, C});
                    visited[R][C] = true;
                }
            }
        }


    }
}