import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Product implements Comparable<Product>{
    int w;
    int v;

    public Product(int w, int v) {
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Product p) {
        return Integer.compare(this.w, p.w);
    }

}

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long sum = 0;
        PriorityQueue<Product> pq = new PriorityQueue<>((p1, p2) -> {
        	return Integer.compare(p1.w, p2.w);
        });
        PriorityQueue<Product> pq2 = new PriorityQueue<>((p1, p2) -> {
        	return Integer.compare(p2.v, p1.v);
        });
        int[] bags = new int[K];
        
        // 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            // pq 에 무게 순으로 저장
            pq.offer(new Product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        // 가방 값 입력
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(bags);
        // pq 에서 무게가 적은 것부터 빼고 높은 가치 순으로 정렬된 pq2 에 넣는다.
        int idx = 0;
        while(idx < K) {
        	
        	if (!pq.isEmpty()) {
        		if (bags[idx] >= pq.peek().w) {
                    pq2.offer(pq.poll());
        			
        		}else if(pq2.isEmpty()){
        			idx++;
        			
        		}else {
        			
        			// 만일 무게가 넘어가면 idx 를 증가.
        			sum += pq2.poll().v;
        			idx++;
        		}
        		
        	}else if (!pq2.isEmpty()){
        		sum += pq2.poll().v;
    			idx++;
    			
        	}else break;
        	

        }
        
        System.out.println(sum);

    }

}