import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int N, answer;
    static Stack<Integer> stack;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        stack = new Stack<>();
        for (int tc=0; tc<N; tc++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                stack.pop();
            } else {
                stack.push(k);
            }
        }

        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
    }

}