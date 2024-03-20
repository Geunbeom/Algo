import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	char name;
	Node lft;
	Node rgt;
	
	Node(){}
	
	Node(char name){
		this.name=name;
	}
}

public class Main {
	
	static int N;
	static Node[] nodes;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb= new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		
		for (int i=0; i<N; i++) {
			nodes[i] = new Node((char) ('A'+i));
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = st.nextToken().charAt(0);
			int b = st.nextToken().charAt(0);
			int c = st.nextToken().charAt(0);
			
			if (b != '.')
				nodes[a-'A'].lft = nodes[b-'A'];
			if (c != '.')
				nodes[a-'A'].rgt = nodes[c-'A'];
			
		}
		
		pre(nodes[0]);
		sb.append("\n");
		mid(nodes[0]);
		sb.append("\n");
		back(nodes[0]);
		
		bw.write(sb+"");
		bw.flush();
		bw.close();

	}
	public static void pre(Node node) {
		if (node == null) return;
		sb.append(node.name);
		pre(node.lft);
		pre(node.rgt);
		
	}
	
	public static void mid(Node node) {
		if (node == null) return;
		
		mid(node.lft);
		sb.append(node.name);
		mid(node.rgt);
		
	}
	
	public static void back(Node node) {
		if (node == null) return;
		back(node.lft);
		back(node.rgt);
		sb.append(node.name);
		
	}
	
	
}
