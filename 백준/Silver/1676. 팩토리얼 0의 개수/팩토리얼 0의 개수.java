import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int N, answer;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i=1; i<=N; i++) {
            int k = i;
            while (k%5 == 0) {
                answer += 1;
                k /= 5;
            }
        }
    }

}