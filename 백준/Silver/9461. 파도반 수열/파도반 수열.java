import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static long[] arr;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new long[100];
        for (int i=0; i<N; i++) {
            int k = Integer.parseInt(br.readLine())-1;
            if (arr[k] == 0) {
              for (int j=0; j<=k; j++) {
                if (j < 3) arr[j] = 1;
                else arr[j] = arr[j-2] + arr[j-3];
              }
              sb.append(arr[k]).append("\n");
              
            } else {
              sb.append(arr[k]).append("\n");
            }

        }
    }

}