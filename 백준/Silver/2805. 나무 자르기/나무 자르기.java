import java.util.*;
import java.io.*;

public class Main {

    
    static int N, M, answer;
    static HashMap<Integer, Integer> dp;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(answer);
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {return b.getKey()-a.getKey();});
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        dp = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            int c = Integer.parseInt(st.nextToken());
            dp.put(c, dp.getOrDefault(c, 0)+1);
        }
        pq.addAll(dp.entrySet());
        boolean find = false;
        int curr = 0;
        int prevH = pq.peek().getKey();
        int max = prevH;
        int currV = pq.poll().getValue();

        while(!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();

            if (entry.getKey() == prevH) continue;
            int k = entry.getKey();
            int v = entry.getValue();
            int t = M-curr;
            if ((prevH-k)*currV >= t) {
                answer = prevH-(t/currV+(t%currV == 0 ? 0 : 1));
                find = true;
                break;
            }else {
                curr += (prevH-k)*currV;
                prevH = k;
                currV += v;
            }
        }
        if (!find) {
            int t = M-curr;
            answer = prevH-(t/currV+(t%currV == 0 ? 0 : 1));
        }
    }
}