package 사전테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2AI의반란최후의전쟁 {
	static long dfs(int n, int a, int b, int c) {
		if (n == N) {
			if (a == 0 || b == 0 || c == 0) {
				return Integer.MAX_VALUE;
			}
			return 0;
		}

		int _str = arr[n][0];
		int _int = arr[n][1];
		int _dex = arr[n][2];

		long val = Integer.MAX_VALUE;
		if (a < N - 2) {
			val = Math.min(val, _int + _dex + dfs(n + 1, a + 1, b, c));
		}
		if (b < N - 2) {
			val = Math.min(val, _str + _dex + dfs(n + 1, a, b + 1, c));
		}
		if (c < N - 2) {
			val = Math.min(val, _str + _int + dfs(n + 1, a, b, c + 1));
		}

		dp[n][a][b][c] = val;
		return dp[n][a][b][c];
	}

	static int N;
	static int[][] arr;
	static long[][][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][3];
			dp = new long[N + 1][N - 1][N - 1][N - 1];
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			dfs(1, 0, 0, 0);
		}

	}

}
