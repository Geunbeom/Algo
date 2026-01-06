import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static String str;
    static String key;
    static StringBuilder answer;

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.println(answer.length() == 0 ? "FRULA" : answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        key = br.readLine();
        answer = new StringBuilder();
    }

    static void play() {
        Deque<Character> stack = new LinkedList<>();
        Stack<Character> st;
        int l = key.length();

        out: for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (c == key.charAt(key.length()-1) && stack.size() >= l) {
                st = new Stack<>();
                for (int t=l-1; t>=0; t--) {
                    char k = stack.pop();
                    st.push(k);
                    if (k != key.charAt(t)) {
                        while(!st.isEmpty()) stack.push(st.pop());
                        continue out;
                    }
                }
            }
        }
        while (!stack.isEmpty()) answer.append(stack.pollLast());
    }

}