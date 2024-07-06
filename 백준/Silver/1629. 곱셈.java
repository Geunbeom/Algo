import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        System.out.println(abc(N, M, K));

    }

    static long abc(long N, long M, long K) {
        if (M == 1) {
            return N%K;
        }
        long L = abc(N, M/2, K);
        long T = (L*L)%K;
        if (M%2 == 1) {
            return (T*(N%K))%K;
        }else {
            return T;
        }

    }

}
