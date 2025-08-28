import java.util.*;
import java.io.*;
class Main {
  static public void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int c = Integer.parseInt(st.nextToken());
      pq.offer(new int[] {c, i});
    }

    int k = 0;
    int prev = pq.peek()[0];
    while(!pq.isEmpty()) {
      int[] curr = pq.poll();
      if (curr[0] == prev) {
        arr[curr[1]] = k;
        continue;
      }
      prev = curr[0];
      arr[curr[1]] = ++k;
    }

    for (int i : arr) {
      sb.append(i).append(" ");
    }

    System.out.println(sb);
  }
}