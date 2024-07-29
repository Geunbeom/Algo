import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        int M;
        int N;
        int K;
        int[] p;
        int[][] arr;
        boolean[] visitedP;

        for (int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int T = N*M+1;
            p = new int[T];
            arr = new int[N][M];
            visitedP = new boolean[T];
            // index/N = c , index%N = r



            for (int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = r*M+c+1;
                p[k] = k;
                arr[r][c] = 1;
            }

            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    if (arr[r][c] == 0) continue;

                    int k = r*M+c+1;

                    if (r < N-1 && arr[r+1][c] == 1) {
                        merge(p, k, k+M);
                    }if (c < M-1 && arr[r][c+1] == 1) {
                        merge(p, k, k+1);
                    }

                }
            }
            int sum = 0;
            for (int j=0; j<T; j++) {
                int a = p[j];
                if (a == 0 || visitedP[a]) continue;
                int k = findSet(p, j);
                if (!visitedP[k]) {
                    sum += 1;
                    visitedP[k] = true;
                }
            }
            sb.append(sum).append("\n");

        }
        bw.write(sb+"");
        bw.flush();
        bw.close();

    }

    static void merge(int[] p, int x, int y) {
        int fx = findSet(p, x);
        int fy = findSet(p, y);

        if (fx < fy) p[fy] = fx;
        else p[fx] = fy;
    }

    static int findSet(int[] p, int x) {
        if(p[x] != x) return p[x] = findSet(p, p[x]);
        return x;
    }

}
