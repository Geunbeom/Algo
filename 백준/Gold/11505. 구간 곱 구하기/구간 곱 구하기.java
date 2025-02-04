import java.util.*;
import java.io.*;

class Node {
	Node lft;
	Node rgt;
	int n = -1;
	int start;
	int end;
	
	Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Node root = new Node(1, N);
		makeNode(root);
		int t = 0;
		for (int i=0; i<(M+K); i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (k == 1) updateNode(root, a, b);
			else {
				sb.append(getNode(root, a, b));
				t++;
				if (K != t) sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	static public void makeNode(Node curr) throws Exception{
		if (curr.start == curr.end) {
			curr.n = Integer.parseInt(br.readLine());
			return;
		}
		
		int mid = (curr.start + curr.end)/2;
		curr.lft = new Node(curr.start, mid);
		curr.rgt = new Node(mid+1, curr.end);
		makeNode(curr.lft);
		makeNode(curr.rgt);
		curr.n = (int) (( ((long) curr.lft.n) * ((long) curr.rgt.n) ) % 1000000007);
	}
	
	static public void updateNode(Node curr, int i, int n) {
		if (curr.start > i || curr.end < i) return;
		
		if (curr.start == curr.end && curr.start == i) {
			curr.n = n;
			return;
		}
		
		updateNode(curr.lft, i, n);
		updateNode(curr.rgt, i, n);
		curr.n = (int) (( ((long) curr.lft.n) * ((long) curr.rgt.n) ) % 1000000007);
	}
	
	static public int getNode(Node curr, int s, int e) {
		if (curr.start > e || curr.end < s) return -1;
		
		if (curr.start >= s && curr.end <= e) {
			return curr.n;
		}
		
		int lft = getNode(curr.lft, s, e);
		int rgt = getNode(curr.rgt, s, e);
		
		if (lft < 0 && rgt < 0) return -1;
		else if (lft < 0) return rgt;
		else if (rgt < 0) return lft;
		else return (int) (( ((long) lft) * ((long) rgt) ) % 1000000007);
	}
}