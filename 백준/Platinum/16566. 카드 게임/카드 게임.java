import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        boolean[] visited = new boolean[M];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[Integer.parseInt(st.nextToken())] += 1;
        }
        for (int i=0; i<=N; i++) {
            if (arr[i] > 0) {
                list.add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            int now = Integer.parseInt(st.nextToken());
            int result = binarySearch(now);
            while(visited[result]) {
                result++;
            }
            System.out.println(list.get(result));
            visited[result] = true;
        }


    }

    static int binarySearch(int in) {
        int s = 0;
        int e = list.size()-1;
        int mid = 0;
        while(s <= e) {
            mid = (s + e) / 2;
            if (list.get(mid) == in) {
                return (mid+1);
            }
            if (list.get(mid) < in) {
                s = mid + 1;
            } else {
                e = mid-1;
            }
        }

        return mid;
    }

}