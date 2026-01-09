import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static String[] dp;

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(dp[M]);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dp = new String[M+1];
    }

    static void play() {
        for (int i=N-1; i>=0; i--) {
            int k = arr[i];
            for (int j=k; j<=M; j++) {
                String target = cal(dp[j-k], (char) (i+48));
                if ((dp[j]==null?"":dp[j]).length() == target.length())
                dp[j] = (dp[j]==null?"0":dp[j]).compareTo(target) > 0 ? dp[j] : target;
                else dp[j] = (dp[j]==null?"":dp[j]).length()>target.length()?dp[j]:target;
            }
        }
    }

    static String cal(String in, char c) {
        if (in == null) return String.valueOf(c);
        if (in.charAt(0)=='0' && c == '0') return "0";
        int l = in.length();
        StringBuilder sb = new StringBuilder();
        boolean isTrue = false;
        for (int i=0; i<l; i++) {
            char t = in.charAt(i);
            if (t > c) sb.append(t);
            else if(isTrue)sb.append(t);
            else {
                sb.append(c).append(t);
                isTrue = true;
            }
        }
        if (!isTrue) sb.append(c);

        return sb.toString();
    }
}