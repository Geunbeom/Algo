import java.io.*;
import java.util.*;

class Node {
	Node par;
	ArrayList<Node> link = new ArrayList<Node>();
	boolean isCheck = false;
}

public class Main {
	
	static LinkedList<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[N+1];
		Arrays.setAll(nodes, i -> new Node());
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].link.add(nodes[b]);
			nodes[b].link.add(nodes[a]);
		}
		
		makeTree(null, nodes[1]);
		
		int answer = 0;
		while(!q.isEmpty()) {
			Node curr = q.pop();
			if (curr.isCheck || curr.par == null) continue;
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
		q.offer(curr);
	}
}