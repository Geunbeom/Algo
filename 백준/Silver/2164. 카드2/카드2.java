import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int N;
    static Deque<Integer> dq;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(dq.poll());
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<>();
        boolean check = N%2==0;
        if (N == 1) dq.addFirst(1);
        for (int n=1; n<=N; n++) {
            if (n%2==0) dq.addLast(n);
        }
        while(dq.size() > 1) {
            int k = dq.pollFirst();
            if (!check) {
                dq.addLast(k);
            }
            check = !check;
        }
    }

}