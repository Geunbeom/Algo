import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static boolean isFind;
    static int answer;

    static public void main(String[] args) throws Exception {
        input();
        if (N == M) System.out.println(0);
        else {
            play();
            System.out.println(isFind ? answer:-1);
        }
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
    }

    static void play() {
        LinkedList<Integer> q = new LinkedList<>();
        isFind = false;
        q.offer(N);
        out: while(!q.isEmpty()) {
            int l = q.size();
            answer += 1;
            for (int i=0; i<l; i++) {
                int curr = q.poll();
                if (curr*2 == M) {
                    answer += 1;
                    isFind = true;
                    break out;
                } else if(curr*2 < M) {
                    q.offer(curr*2);
                }
    
                long T = (long) curr*10+1;
                if (T == M) {
                    answer += 1;
                    isFind = true;
                    break out;
                } else if (T<=1000000000 && T < M) {
                    q.offer((int) T);
                }
            }
        }
    }

}