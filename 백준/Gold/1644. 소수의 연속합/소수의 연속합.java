import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> list;
    static ArrayList<Integer> dp;
    static int N;
    public static void main(String[] args) throws Exception{
        input();
        int answer = 0;
        for (int i=0; i<dp.size(); i++) {
            if (dp.get(i) == N) answer++;
        }
        System.out.println(answer);
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        dp = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        out: for (int n=2; n<=N; n++) {
            for (int i=0; i<list.size(); i++) {
                int k = list.get(i);
                if (k > Math.sqrt(n)) break;
                if (n%k == 0) continue out;
            }
            list.add(n);
            dp.add(n);
            for (int i=dp.size()-2; i>=0; i--) {
                if (dp.get(i) >= N) break;
                dp.set(i, dp.get(i)+n);
            }
        }
        
    }

}