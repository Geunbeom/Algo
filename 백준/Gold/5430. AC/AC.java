import java.util.*;
import java.io.*;

public class Main {

    static int N, answer, TC;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        System.out.print(sb);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());

        out: for (int tc=0; tc<TC; tc++) {
            String ac = br.readLine();
            N = Integer.parseInt(br.readLine());
            String curr = br.readLine();
            String prev = "";
            Deque<String> dq = new LinkedList<>();

            for (int i=0; i<curr.length(); i++) {
                char c = curr.charAt(i);
                if (c >= '0' && c <= '9') {
                    prev += c;
                } else if (c == ',' || c == ']') {
                    if (prev.length() > 0) dq.push(prev);
                    prev = "";
                }
            }

            boolean check = true;
            for (int i=0; i<ac.length(); i++) {
                char c = ac.charAt(i);
                if (c == 'R') {
                    check = !check;
                    continue;
                }
                if (dq.isEmpty()) {
                    sb.append("error").append("\n");
                    continue out;
                }

                if (check) dq.pollLast();
                else dq.pollFirst();
            }

            sb.append("[");
            while(!dq.isEmpty()) {
                if (!check) sb.append(dq.pollFirst());
                else sb.append(dq.pollLast());

                if (!dq.isEmpty()) sb.append(",");
            }
            sb.append("]").append("\n");
        }

    }

}
