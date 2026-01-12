import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer> list;
    static HashMap<Integer, int[]> dp;
    static int answer;


    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        answer = 0;
        int prev = -1;

        while(prev != 0) {
            int curr = Integer.parseInt(st.nextToken());
            if (curr == prev) answer += 1;
            else if (curr != 0) list.add(curr);
            prev = curr;
        }
        N = list.size();
        dp = new HashMap<>();
        dp.put(1, new int[N+1]);
        dp.put(2, new int[N+1]);
        dp.put(3, new int[N+1]);
        dp.put(4, new int[N+1]);
        dp.put(12, new int[N+1]);
        dp.put(13, new int[N+1]);
        dp.put(14, new int[N+1]);
        dp.put(23, new int[N+1]);
        dp.put(24, new int[N+1]);
        dp.put(34, new int[N+1]);
    }

    static void play() {
        if (N<2) {
            answer += 2;
            return;
        }

        for (int key : dp.keySet()) {
            dp.get(key)[1] = (key == list.get(0) ? 2 : 0);
        }

        for (int i=1; i<N; i++) {
            int curr = list.get(i);
            int j = i+1;
            for (int k : dp.keySet()) {
                if (dp.get(k)[i] == 0) continue;

                int l = k / 10;
                int r = k % 10;
                if (r == curr || l == curr) dp.get(k)[j] = Math.min(dp.get(k)[j]==0?Integer.MAX_VALUE:dp.get(k)[j], dp.get(k)[i]+1);
                else {
                    int code1 = Math.min(l, curr)*10 + Math.max(l, curr);
                    int code2 = Math.min(r, curr)*10 + Math.max(r, curr);
                    dp.get(code1)[j] = Math.min(dp.get(code1)[j]==0?Integer.MAX_VALUE:dp.get(code1)[j], dp.get(k)[i]+(r==0?2:Math.abs(r-curr)==2?4:3));
                    dp.get(code2)[j] = Math.min(dp.get(code2)[j]==0?Integer.MAX_VALUE:dp.get(code2)[j], dp.get(k)[i]+(l==0?2:Math.abs(l-curr)==2?4:3));
                }
            }
        }
        
        int t = Integer.MAX_VALUE;
        for (int key : dp.keySet()) {
            if (dp.get(key)[N] == 0) continue;
            t = Math.min(t, dp.get(key)[N]);
        }
        answer += t;
    }
}