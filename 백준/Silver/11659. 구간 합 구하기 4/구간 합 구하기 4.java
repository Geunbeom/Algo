import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, T;
    static int[] arr;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N];
      
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i=1; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for (int tc=0; tc<T; tc++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken())-1;
          int b = Integer.parseInt(st.nextToken())-1;
          sb.append(arr[b]-(a==0?0:arr[a-1])).append("\n");
        }
    }

}