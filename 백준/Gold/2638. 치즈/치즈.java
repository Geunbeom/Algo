import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cnt, N, M;
    static int[][] arr, cheese;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;
        arr = new int[N+2][M+2];

        // 배열 정보를 담는다.
        for (int r=1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=1; c<=M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        while(!isEmpty()) {
            search();
            cnt++;
        }
        System.out.println(cnt);

    }
    static void search() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N+2][M+2];
        cheese = new int[N+2][M+2];

        queue.offer(new int[] {0, 0});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (arr[now[0]][now[1]] == 1) continue;
            for (int j=0; j<4; j++) {
                int X = now[0] + dr[j];
                int Y = now[1] + dc[j];

                if (X < 0 || X > N+1 || Y < 0 || Y > M+1) continue;
                if (arr[X][Y] == 1) cheese[X][Y]++;
                if (visited[X][Y]) continue;
                visited[X][Y] = true;
                queue.offer(new int[] {X, Y});
            }
        }

        delete();

    }

    static void delete() {
        for (int r=1; r<=N; r++) {
            for (int c=1; c<=M; c++) {

                if (arr[r][c] == 0) continue;

                if (cheese[r][c] >= 2) {
                    arr[r][c] = 0;
                }
            }
        }

    }

    static boolean isEmpty() {
        boolean check = true;
        for (int r=1; r<=N; r++) {
            for (int c=1; c<=M; c++) {
                if (arr[r][c] == 0) continue;
                check = false;
            }
        }
        return check;
    }

}