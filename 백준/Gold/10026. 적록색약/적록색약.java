import java.util.*;
import java.io.*;

public class Main {

    static int N, answer1, answer2;
    static char[][] arr;
    static boolean[][] visited1, visited2;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.println(answer1 + " " + answer2);
    }

    static void play() {
        int[] dr = new int[]{0, 0, -1, 1};
        int[] dc = new int[]{-1, 1, 0, 0};

        LinkedList<int[]> q = new LinkedList<>();
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (!visited1[r][c]) {
                    q.offer(new int[] {r, c});
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int i=0; i<4; i++) {
                            int R = curr[0]+dr[i];
                            int C = curr[1]+dc[i];
                            if (R < 0 || C < 0 || R >= N || C >= N || visited1[R][C]) continue;
                            if (arr[R][C] == arr[r][c]) {
                                q.offer(new int[] {R, C});
                                visited1[R][C] = true;
                            }
                        }
                    }
                    answer1++;
                }

                if (!visited2[r][c]) {
                    q.offer(new int[] {r, c});
                    char t = arr[r][c] == 'B' ? 'B' : (arr[r][c] == 'G' ? 'R' : 'G');
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int i=0; i<4; i++) {
                            int R = curr[0]+dr[i];
                            int C = curr[1]+dc[i];
                            if (R < 0 || C < 0 || R >= N || C >= N || visited2[R][C]) continue;
                            if (arr[R][C] == t || arr[R][C] == arr[r][c]) {
                                q.offer(new int[] {R, C});
                                visited2[R][C] = true;
                            }
                        }
                    }
                    answer2++;
                }
            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        answer1 = 0;
        answer2 = 0;

        arr = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String curr = br.readLine();
            for (int c=0; c<N; c++) {
                char t = curr.charAt(c);
                arr[i][c] = t;
            }
        }

    }

}