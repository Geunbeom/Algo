import java.util.*;
import java.io.*;
public class Main {

    static int N, M, H, answer;
    static int[][][] arr;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, -1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.println(answer);
    }

    private static void play() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][H];

        for (int h=0; h<H; h++) {
            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    if (arr[r][c][h] == 1) {
                        queue.offer(new int[]{r, c, h});
                        visited[r][c][h] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i=0; i<size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int z = current[2];

                for (int d=0; d<6; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nz = z + dz[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                    if (visited[nx][ny][nz] || arr[nx][ny][nz] != 0) continue;

                    visited[nx][ny][nz] = true;
                    arr[nx][ny][nz] = 1;
                    queue.offer(new int[]{nx, ny, nz});
                }
            }
        }

        for (int h=0; h<H; h++) {
            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    if (arr[r][c][h] == 0) {
                        answer = -1;
                        return;
                    }
                }
            }
        }

        answer--;
    }

    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];

        for (int h=0; h<H; h++) {
            for (int r=0; r<N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c=0; c<M; c++) {
                    arr[r][c][h] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

}
