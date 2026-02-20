import java.util.*;
import java.io.*;

class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;
  static int N;
  static int[][] arr;
  static public void main(String[] args) throws Exception {
    input();
    System.out.print(sb);
  }

  static public void input() throws Exception{
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    arr = new int[N][2];
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int r=0; r<N; r++) {
      int count = 1;
      for (int c=0; c<N; c++) {
        if (r == c) continue;
        if (arr[r][0] < arr[c][0] && arr[r][1] < arr[c][1]) count++;
      }
      sb.append(count).append("\n");
    }

    
  }
}