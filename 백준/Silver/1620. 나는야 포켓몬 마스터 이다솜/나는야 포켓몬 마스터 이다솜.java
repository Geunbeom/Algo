import java.util.*;
import java.io.*;
class Main {
  static public void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> map = new HashMap<>();
    String[] arr = new String[N+1];
    for (int i=1; i<=N; i++) {
      String curr = br.readLine();
      map.put(curr, i);
      arr[i] = curr;
    }

    for (int i=0; i<M; i++) {
      String str = br.readLine();
      try {
        int k = Integer.parseInt(str);
        sb.append(arr[k]);
      } catch(Exception e) {
        sb.append(map.get(str));
      }
      if (i != M-1) sb.append("\n");
    }
    System.out.print(sb);
  }
}