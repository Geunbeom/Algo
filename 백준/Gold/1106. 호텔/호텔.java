import java.util.*;
import java.io.*;

public class Main {

    static int index;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap <Integer, Integer> map = new HashMap<>();
        int[] dp = new int[C+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            b = b > C ? C : b;
            map.put(b, Math.min(map.getOrDefault(b, 1000), a));
            dp[b] = map.get(b);
        }

        for (index=1; index<=C; index++) {
            if (dp[index] == 0) continue;
            map.forEach((k, v) -> {
                int i = index+k>=C?C:index+k;
                dp[i] = Math.min(dp[i]==0?Integer.MAX_VALUE:dp[i], dp[index]+v);
            });
        }

        System.out.println(dp[C]);
    }

}