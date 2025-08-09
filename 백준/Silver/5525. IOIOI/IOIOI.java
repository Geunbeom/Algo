import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static String str;
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        input();
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();
        answer = 0;
        int idx = 0;
        int count = 0;
        while(idx < M) {
            char c = str.charAt(idx);
            if (c == 'O') {
                idx++;
                count = 0;
                continue;
            }

            if (count == N) {
                answer += 1;
                count--;
            }
            if (idx == M-1) break;

            char n = str.charAt(++idx);
            idx++;

            if (n == 'I') {
                count = 0;
                idx--;
                continue;
            }
            count++;
        }
        
        System.out.println(answer);
    }

}