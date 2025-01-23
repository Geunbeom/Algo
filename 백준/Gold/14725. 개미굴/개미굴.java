import java.io.*;
import java.util.*;

class Node {
	String name;
	SortedMap<String, Node> map = new TreeMap<>();
	
	Node(String name) {
		this.name = name;
	}
}

public class Main {
	
	static LinkedList<String> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Node root = new Node("root");
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Node prev = root;
			Node curr;
			for (int j=0; j<k; j++) {
				String a = st.nextToken();
				
				if(prev.map.get(a) != null) {
					curr = prev.map.get(a);
					prev = curr;
					continue;
				}
				max++;
				
				curr = new Node(a);
				prev.map.put(a, curr);
				prev = curr;
			}
		}
		dfs(root, 0);
		System.out.print(sb);
	}
	
	static public void dfs(Node curr, int index) {
		if (curr.map.isEmpty()) {
			return;
		}
		
		for(String key : curr.map.keySet()) {
			Node next = curr.map.get(key);
			
			for (int i=0; i<index; i++) {
				sb.append("--");
			}
			max--;
			sb.append(next.name);
			if (max > 0)sb.append("\n");
			dfs(next, index+1);
		}
	}
}