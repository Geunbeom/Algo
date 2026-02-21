import java.util.*;
import java.io.*;

class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;
  static int N;
  static String[] arr;
  static PriorityQueue<int[]> pq;
  static public void main(String[] args) throws Exception {
    input();
    System.out.print(sb);
  }

  static public void input() throws Exception{
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    arr = new String[N];
    pq = new PriorityQueue<>((a, b) -> {
      if (a[0] != b[0]) return a[0]-b[0];
      else return a[1]-b[1];
    });
    
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      String s = st.nextToken();
      pq.offer(new int[] {k, i});
      arr[i] = s;
    }

    while (!pq.isEmpty()) {
      int[] t = pq.poll();
      sb.append(t[0]).append(" ").append(arr[t[1]]).append("\n");
    }
  }
}