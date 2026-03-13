import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static Stack<Character> stack;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        out: for(int tc=0; tc<N; tc++) {
          String curr = br.readLine();
          int l = curr.length();
          stack = new Stack<>();
          for (int i=0; i<l; i++) {
            char c = curr.charAt(i);
            if (c == '(') stack.push(c);
            else {
              if (stack.isEmpty() || stack.peek() != '(') {
                sb.append("NO").append("\n");
                continue out;
              }
              stack.pop();
            }
          }
          if (stack.isEmpty()) {
            sb.append("YES").append("\n"); 
          } else {
            sb.append("NO").append("\n"); 
          }
        }
    }

}