import java.io.*;
import java.util.*;

class Node {
	Node par;
	ArrayList<Node> link = new ArrayList<Node>();
	boolean isCheck = false;
}

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[N+1];
		
		LinkedList<Node> q = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (nodes[a] == null) {
				nodes[a] = new Node();
			}
			if (nodes[b] == null) nodes[b] = new Node();
			nodes[a].link.add(nodes[b]);
			nodes[b].link.add(nodes[a]);
		}
		
		makeTree(null, nodes[1]);
		nodes[1].link.forEach((v)->q.offer(v));
		
		while(!q.isEmpty()) {
			int l = q.size();
			for (int i=0; i<l; i++) {
				Node curr = q.pop();
				stack.add(curr);
				curr.link.forEach((v)->{
					if(v != curr.par) q.offer(v);
				});
			}
		}
		
		int answer = 0;
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			if (curr.isCheck) continue;
			if (!curr.par.isCheck) {
				curr.par.isCheck = true;
				answer++;
			}
		}
		System.out.println(answer);

	}
	
	static public void makeTree(Node prev, Node curr) {
		for (Node next : curr.link) {
			if (next == prev) continue;
			next.par = curr;
			makeTree(curr, next);
		}
	}
}