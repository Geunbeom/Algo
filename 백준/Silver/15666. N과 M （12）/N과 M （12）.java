import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr, answer;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.print(sb);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    static void play() {
        dfs(0, 0);
    }

    static void dfs(int count, int index) {
        if (count == M) {
            for (int i=0; i<M; i++) sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i=index; i<N; i++) {
            if (prev == arr[i]) continue;
            answer[count] = arr[i];
            dfs(count+1, i);
            prev = arr[i];
        }
    }

}