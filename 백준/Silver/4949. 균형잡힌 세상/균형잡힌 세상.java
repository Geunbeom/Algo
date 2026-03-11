import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static Stack<Character> stack;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String curr = br.readLine();
        out: while(!(curr.length() == 1 && curr.charAt(0) == '.')) {
          int l = curr.length();
          stack = new Stack<>();
          for (int i=0; i<l; i++) {
            char c = curr.charAt(i);
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (c == ')') {
              if (stack.isEmpty() || stack.peek() != '(') {
                sb.append("no").append("\n");
                curr = br.readLine();
                continue out;
              }
              stack.pop();
            }else if (c == '}') {
              if (stack.isEmpty() || stack.peek() != '{') {
                sb.append("no").append("\n");
                curr = br.readLine();
                continue out;
              }
              stack.pop();
            }else if (c == ']') {
              if (stack.isEmpty() || stack.peek() != '[') {
                sb.append("no").append("\n");
                curr = br.readLine();
                continue out;
              }
              stack.pop();
            }
          }
          if (stack.isEmpty()) {
            sb.append("yes").append("\n"); 
          } else {
            sb.append("no").append("\n"); 
          }
          curr = br.readLine();
        }
    }

}