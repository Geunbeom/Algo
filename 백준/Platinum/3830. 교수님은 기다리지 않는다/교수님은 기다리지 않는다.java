import java.util.*;
import java.io.*;

public class Main {
	
	static final int max = Integer.MAX_VALUE;
	static int[][] p;
	static int[] size;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			p = new int[N+1][2];
			size = new int[N+1];
			
			while(W-- > 0) {
				int output = 0;
				String[] arr = br.readLine().split(" ");
				
				if (arr[0].equals("!")) {
					makeGraph(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
				}else {
					output = getAnswer(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
					
					sb.append(output == max ? "UNKNOWN" : output);
					sb.append("\n");
				}
			}
		}
		System.out.print(sb);
	}

	private static int getAnswer(int a, int b) {
		if (p[a][0] == 0 || p[b][0] == 0) return max;
		int sum = getSum(a, b, 0);
		if (sum == max) return max;
		return sum;
	}

	private static int getSum(int a, int b, int sum) {
		if (a == b) return sum;
		if (a < b) {
			if (b != p[b][0]) return getSum(a, p[b][0], sum+p[b][1]);
			else if (a != p[a][0]) return getSum(p[a][0], b, sum-p[a][1]);
		} else {
			if(a != p[a][0] && a > b) return getSum(p[a][0], b, sum-p[a][1]);
			else if(b != p[b][0]) return getSum(a, p[b][0], sum+p[b][1]);
		}
		return max;
	}

	private static void makeGraph(int a, int b, int w) {
		if (p[a][0] == 0) {
			p[a][0] = a;
			size[a] = 1;
		}
		if (p[b][0] == 0) {
			p[b][0] = b;
			size[b] = 1;
		}
		union(a, b, w);
	}

	private static void union(int a, int b, int w) {
		if (p[a][0] == p[b][0]) return;
		int[] fa = findSet(a, 0);
		int[] fb = findSet(b, 0);
		
		if (size[fa[0]] < size[fb[0]]) {
			p[fa[0]][0] = p[fb[0]][0];
			p[fa[0]][1] = fb[1] - fa[1] - w;
			size[fb[0]] += size[fa[0]];
			size[fa[0]] = 0;
		}
		else {
			p[fb[0]][0] = p[fa[0]][0];
			p[fb[0]][1] = w + fa[1] - fb[1];
			size[fa[0]] += size[fb[0]];
			size[fb[0]] = 0;
		}
	}

	private static int[] findSet(int a, int sum) {
		if (a == p[a][0]) return new int[] {a, sum};
		return findSet(p[a][0], sum+p[a][1]);
	}
}