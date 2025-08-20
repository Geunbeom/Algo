import java.util.*;
import java.io.*;

public class Main {

    static int N, count;
    static int[] arr;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(count);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int prev = 0;
        int next = 0;
        int index = 0;
        count = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;

            if ((map.size() < 2 || map.containsKey(k)) && i != N-1) map.put(k, i);
            else {
                count = Math.max(count, i-index+((map.size() < 2 || map.containsKey(k))?1:0));
                index = map.getOrDefault(prev, 0)+1;
                map.remove(prev);
                map.put(k, i);
            }
            
            if (prev == 0) prev = k;
            else if ((next == 0 && prev != k) || next != k) {
                prev = arr[i-1];
                next = k;
            }

        }
    }

}