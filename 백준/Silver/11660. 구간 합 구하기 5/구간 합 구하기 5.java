import java.util.*;
import java.io.*;
public class Main {

    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        input();
    }

    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer. parseInt(st.nextToken());
        arr = new int[N][N];

        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            int prev = 0;
            for (int c=0; c<N; c++) {
                int k = Integer.parseInt(st.nextToken());
                prev += k;
                arr[r][c] = arr[r>0?r-1:r][c]+prev;
            }
        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int k = arr[x2][y2] - (x1==0?0:arr[x1-1][y2]) - (y1==0?0:arr[x2][y1-1]) + (x1==0||y1==0?0:arr[x1-1][y1-1]);
            sb.append(k);
            if (m != M-1) sb.append("\n");
        }

        System.out.print(sb);
    }

}
