import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세그먼트 트리를 클래스로 구현해보기
class Node {
	long sum;
	Node parent;
	Node lft;
	Node rgt;
	
	Node(){}
	
	Node (long sum, Node parent, Node lft, Node rgt){
		this.sum = sum;
		this.parent = parent;
		this.lft = lft;
		this.rgt = rgt;
	}
	
}

public class Main {
	
	static int k;
	static Node[] nodes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		k=1;

		for (int i=0; i<32; i++) {
			k<<=i;
			if (N <= k) break;
		}
		int size = N+k;
		
		nodes = new Node[k<<1];
		
		if (N == 1) {
			nodes[1] = new Node();
			nodes[1].sum = Long.parseLong(br.readLine());
		}else if (N == 2) {
			nodes[1] = new Node();
			nodes[2] = new Node();
			nodes[3] = new Node();
			
			nodes[2].sum = Long.parseLong(br.readLine());
			nodes[3].sum = Long.parseLong(br.readLine());
			
			nodes[1].sum = nodes[2].sum + nodes[3].sum; 
			
			nodes[1].lft = nodes[2];
			nodes[1].rgt = nodes[3];
			nodes[2].parent = nodes[1];
			nodes[3].parent = nodes[1];
			
		}else {
			nodes[1] = new Node();
		
			for (int i=2; i<k<<1; i++) {
				
				nodes[i] = new Node();
				nodes[i].parent = nodes[i/2];
				
				if (i%2 == 0) nodes[i].parent.lft = nodes[i];
				else nodes[i].parent.rgt = nodes[i];
				
				if (i>=k && i<size) {
					long sum = Long.parseLong(br.readLine());
					nodes[i].sum = sum;
				}
			}
		}
		if (N != 1 && N != 2) {
			for (int i=size; i>=2; i--) {
				if (i%2 == 0) {
					nodes[i].parent.sum = nodes[i].sum + nodes[i+1].sum;
				}
			}		
		}
		
//		for (int i=1; i<size; i++) {
//			System.out.print(nodes[i].sum+" ");
//		}
		
		for (int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				treeReplace(b, c);				
			}else {
				sb.append(treeSum(1, k, nodes[1], b, c) + "\n");
			}
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}
	
	static void treeReplace(int n, long sum) {
		Node nowNode = nodes[k+n-1];
		nowNode.sum = sum;
		
		while (nowNode.parent != null) {
			nowNode = nowNode.parent;
			nowNode.sum = nowNode.lft.sum + nowNode.rgt.sum;
		}
		
	}
	
	static long treeSum(int start, int end, Node node, int sumS, long sumE) {
		if (sumS > end || sumE < start) return 0;
		if (sumS<=start && sumE >= end) {
			return node.sum;
		}
		
		int mid = (start+end)/2;
		return treeSum(start, mid, node.lft, sumS, sumE)+treeSum(mid+1, end, node.rgt, sumS, sumE);
	}
	
}
