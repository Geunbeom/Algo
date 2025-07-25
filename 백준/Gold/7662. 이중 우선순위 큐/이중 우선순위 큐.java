import java.util.*;
import java.io.*;

public class Main {

    static int TC;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(sb);
    }

    private static void play(int N) throws Exception{
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            if (c == 'I') {
                map.put(n, map.getOrDefault(n, 0) + 1);
            } else if (c == 'D') {
                if (n == 1) {
                    if (!map.isEmpty()) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    }
                } else if (n == -1) {
                    if (!map.isEmpty()) {
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
        }
        sb.append(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());

        for (int tc=0; tc<TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            play(N);
        }
    }

}
