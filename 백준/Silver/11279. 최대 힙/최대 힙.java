import java.util.*;
import java.io.*;

public class Main {
	
    static int N;
	static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		init();
		System.out.print(sb);
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            if (c == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else pq.offer(c);
        }
	}

}