import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long N = Long.parseLong(br.readLine());
		long K = 0;
		ArrayList<Long> list = new ArrayList<>();
		
		out : for (long i=2; i<=Math.round(Math.sqrt(N)); i++) {
			if (N%i != 0) continue;
			long k = N/i;
			boolean a = false;
			boolean b = false;
			long max1 = Math.round(Math.sqrt(k));
			long max2 = Math.round(Math.sqrt(i));
			
			for (int j=2; j<=max1; j++) {
				if(j <= max2 && i%j == 0) a = true;
				if(k%j == 0) b = true;
				if(a && b) continue out;
			}
			if(!a) list.add(i);
			if(!b && i != k && k != N) list.add(k);
		}
		
		for (int i=1; i<(1<<list.size()); i++) {
			int count = 0;
			long curr = 1;
			for (int b=0; b<list.size(); b++) {
				int bit = 1<<b;
				if ((bit & i) != 0) {
					count+=1;
					curr*=list.get(b);
				}
			}
			if (count%2 == 1) K+=(N/curr);
			else K-=(N/curr);
		}
		if (K==0 && N != 1) K=1;
		System.out.println(N-K);
	}
	
}