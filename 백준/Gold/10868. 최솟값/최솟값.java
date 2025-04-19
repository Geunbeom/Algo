import java.util.*;
import java.io.*;

class Node {
	int min;
	Node l;
	Node r;
	int s;
	int e;
	
	Node(int s, int e) {
		this.s = s;
		this.e = e;
	}
}

public class Main {
	
	static int N, M;
	static Node root;
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception{
		init();
	}

	private static int solution(int s, int e, Node node) {
		if (node.s > e || node.e < s) return -1;
		if (node.s >= s && node.e <= e) return node.min;
		
		int lft = solution(s, e, node.l);
		int rgt = solution(s, e, node.r);
		
		if (lft == -1) return rgt;
		else if (rgt == -1) return lft;
		else return Math.min(lft, rgt);
	}
	
	private static Node makeTree(Node node) throws Exception {
		if (node.s == node.e) {
			int k = Integer.parseInt(br.readLine());
			node.min = k;
			return node;
		}
		
		int mid = (node.s+node.e)/2;
		node.l = makeTree(new Node(node.s, mid));
		node.r = makeTree(new Node(mid+1, node.e));
		node.min = Math.min(node.l.min, node.r.min);
		
		return node;
	}
	
	private static void init() throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		root = new Node(1, N);
		
		makeTree(root);
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(solution(s, e, root) + (i != M-1 ? "\n" : ""));
		}
		System.out.print(sb);
	}
}