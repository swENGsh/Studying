package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 둘째주_0918_츄러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int[] churros;

    static boolean test(int mid) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            int now = churros[i];
            cnt += now / mid;
            if (cnt >= K)
                return true;
        }
        return false;
    }

    static void psearch() {
        int left = 1;
        int right = Integer.MAX_VALUE -1;

        while(left <= right) {
            int mid = (right + left) / 2;
            if (test(mid)) {
                left = mid + 1;
            }
            else {
                right = mid = 1;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        churros = new int[N];
        for (int i=0; i<N; i++) {
            if (MAX < churros[i])
                MAX = churros[i];
        }

        psearch();
    }
}
