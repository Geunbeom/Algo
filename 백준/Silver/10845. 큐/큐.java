import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            char key = k.charAt(1);
            switch (key){
                case 'u':
                    int t = Integer.parseInt(st.nextToken());
                    q.offer(t);
                    break;
                case 'r':
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                case 'a':
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.peekLast()).append("\n");
                    break;
                case 'm':
                    if (q.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case 'i':
                    sb.append(q.size()).append("\n");
                    break;
                case 'o':
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.pop()).append("\n");
                    break;
            }
        }
    }
}