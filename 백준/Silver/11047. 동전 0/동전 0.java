import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static Stack<Integer> stack;
    static int N, K, answer;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stack = new Stack<>();
        for (int i=0; i<N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }
        while (!stack.isEmpty()) {
            int t = stack.pop();
            if (t > K) continue;
            answer += (K/t);
            K = K%t;
            if (K == 0) break;
        }
    }


}