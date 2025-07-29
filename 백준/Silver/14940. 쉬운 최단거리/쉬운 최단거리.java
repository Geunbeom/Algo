import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static int[][] arr;
    static int[] start;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.print(sb);
    }

    private static void play() {
        LinkedList<int[]> q = new LinkedList<>();
        int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {1, -1, 0, 0};
        q.offer(start);
        int count = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            count++;
            for (int i=0; i<l; i++) {
                int[] curr = q.poll();
                for (int d=0; d<4; d++) {
                    int R = curr[0]+dr[d];
                    int C = curr[1]+dc[d];
                    if (R < 0 || R >= N || C < 0 || C >= M || arr[R][C] != -1) continue;
                    q.offer(new int[] {R, C});
                    arr[R][C] = count;
                }
            }
        }
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                sb.append(arr[r][c]);
                if (c != M-1) sb.append(" ");
            }
            if (r != N-1) sb.append("\n");
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<M; c++) {
                int curr = Integer.parseInt(st.nextToken());
                if (curr == 2) start = new int[] {r, c};
                else if (curr == 1) arr[r][c] = -1;
            }
        }

    }

}
