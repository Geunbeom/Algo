import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a, b;
	double d;
	
	Edge(){}
	Edge (int a, int b, double d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.d, o.d);
	}
	
}

public class Main {
	
	static void union(int x, int y) {
		if (x > y) p[x] = y;
		else p[y] = x;
	}
	
	static int findset(int x) {
		if (p[x] != x) p[x] = findset(p[x]);
		return p[x];
	}
	
	static double[] x, y;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		x = new double[N];
		y = new double[N];
		p = new int[N];
		
		for (int i=0; i<N; i++) {
			p[i] = i;
		}
		
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			double X = Double.parseDouble(st.nextToken());
			double Y = Double.parseDouble(st.nextToken());
			x[i] = X;
			y[i] = Y;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				
				double d = Math.sqrt(Math.abs(x[i]-x[j])*Math.abs(x[i]-x[j]) + Math.abs(y[i]-y[j])*Math.abs(y[i]-y[j]));
				
				pq.offer(new Edge(i, j, d));
			}
		}
		int k = 0;
		double ans = 0;
		while(k != N-1) {
			Edge e = pq.poll();
			int px = findset(e.a);
			int py = findset(e.b);
			
			if(px == py) continue;

			union(px, py);
			ans += e.d;
			k++;
		}
		
		System.out.printf("%.2f", ans);
		
		
	}
}
