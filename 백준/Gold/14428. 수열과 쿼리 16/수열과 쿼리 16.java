import java.util.*;
import java.io.*;

class Node {
	int start;
	int end;
	int n;
	int i;
	Node lft;
	Node rgt;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	
}

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int index = 1;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		
		Node root = new Node(1, N);
		
		st = new StringTokenizer(br.readLine());
		makeNode(root);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		boolean first = true;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) update(root, b, c);
			else {
				if (!first) sb.append("\n");
				first = false;
				getNode(root, b, c);
				sb.append(getNode(root, b, c)[1]);
			}
		}
		System.out.println(sb);
	}
	
	public static void makeNode(Node curr) throws Exception{
		if (curr.start == curr.end) {
			curr.n = Integer.parseInt(st.nextToken());
			curr.i = index++;
			return;
		}
		
		int mid = (curr.start + curr.end)/2;
		curr.lft = new Node(curr.start, mid);
		curr.rgt = new Node(mid+1, curr.end);
		makeNode(curr.lft);
		makeNode(curr.rgt);
		
		if (curr.lft.n <= curr.rgt.n) {
			curr.i = curr.lft.i;
			curr.n = curr.lft.n;
		} else {
			curr.i = curr.rgt.i;
			curr.n = curr.rgt.n;
		}
	}
	
	public static void update(Node curr, int index, int v) {
		if (curr.start == curr.end) {
			curr.n = v;
			return;
		}

		int mid = (curr.start + curr.end)/2;
		if (curr.start <= index && mid >= index) {
			update(curr.lft, index, v);			
		}else update(curr.rgt, index, v);
		
		
		if (curr.lft.n <= curr.rgt.n) {
			curr.i = curr.lft.i;
			curr.n = curr.lft.n;
		} else {
			curr.i = curr.rgt.i;
			curr.n = curr.rgt.n;
		}
	}
	
	public static int[] getNode(Node curr, int s, int e) {
		if (curr.start > e || curr.end < s) return new int[] {Integer.MAX_VALUE, 0};
		if (curr.start >= s && curr.end <= e) return new int[] {curr.n, curr.i};
		
		int[] lft = getNode(curr.lft, s, e);
		int[] rgt = getNode(curr.rgt, s, e);
		
		if (lft[0] <= rgt[0]) {
			return lft;
		} else {
			return rgt;
		}
	}
}