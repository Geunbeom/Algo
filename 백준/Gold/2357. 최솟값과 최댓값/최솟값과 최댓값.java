import java.util.*;
import java.io.*;

class Node {
	Node lft;
	Node rgt;
	int max = -1;
	int min = -1;
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
		Node root = new Node(1, N);
		makeTree(root);
		inputM(root);
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int[] answer = check(root, s, e);
			sb.append(answer[1] + " " + answer[0]);
			if (i != M-1) sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static public void makeTree(Node curr) throws Exception {
		if (curr.start == curr.end) {
			curr.max = Integer.parseInt(br.readLine());
			curr.min = curr.max;
			return;
		}
		int mid = (curr.start+curr.end)/2;
		curr.lft = new Node(curr.start, mid);
		curr.rgt = new Node(mid+1, curr.end);
		makeTree(curr.lft);
		makeTree(curr.rgt);
	}
	
	static public int[] inputM(Node curr) {
		if (curr.max != -1) return new int[] {curr.max, curr.min};
		
		int[] l = inputM(curr.lft);
		int[] r = inputM(curr.rgt);
		curr.max = Math.max(l[0], r[0]);
		curr.min = Math.min(l[1], r[1]);
		return new int[] {curr.max, curr.min};
	}
	
	static public int[] check(Node curr, int s, int e) {
		if (curr.start > e || curr.end < s) return new int[] {-1, -1};
		if (curr.start >= s && curr.end <= e) return new int[] {curr.max, curr.min};
		
		int[] lft = check(curr.lft, s, e);
		int[] rgt = check(curr.rgt, s, e);
		
		if (lft[0] == -1 && rgt[0] == -1) return new int[] {-1, -1};
		else if (lft[0] == -1) return rgt;
		else if (rgt[0] == -1) return lft;
		else return new int[] {Math.max(lft[0], rgt[0]), Math.min(lft[1], rgt[1])};
	}
}