import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N, T;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        T = 0;
        for (int i=0; i<N; i++) {
            T = 0;
            int k = Integer.parseInt(br.readLine());
            play(k, 0, 0);
            sb.append(T).append("\n");

        }
    }

    static void play(int k, int sum, int count) {
        if (sum > k) return;
        else if (sum == k) T+=1;
        else {
            play(k, sum+1, count+1);
            play(k, sum+2, count+1);
            play(k, sum+3, count+1);
        }
    }


}