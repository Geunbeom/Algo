import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static Stack<Integer> stack;
    static int N;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            if (c2 == 'u') {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (c2 == 'o' && c1 == 't') {
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }else if (c2 == 'i') sb.append(stack.size()).append("\n");
            else if (c2 == 'o' && c1 =='p') {
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if (c2 == 'm') {
                if (stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

        }
    }


}