package miracom.프로원정대10기.첫째주._1일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2_연쇄폭탄_DAT이용 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[][] bombInfo = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				bombInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] DAT = new int[n * n + 1][2];
		DAT[0][0] = -9;
		DAT[0][1] = -9;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				DAT[bombInfo[i][j]][0] = i;
				DAT[bombInfo[i][j]][1] = j;
			}
		}
		
		int cnt = 0;
		for (int i = 1; i < n * n + 1; i++) {
			if (DAT[i][0] == -9 && DAT[i][1] == -9)
				continue;
			ans = i;
			cnt ++;
			int r = DAT[i][0];
			int c = DAT[i][1];
			bombInfo[r][c] = -9;
			DAT[i][0] = -9;
			DAT[i][1] = -9;
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (0 > nr || n <= nr || 0 > nc || n <= nc || bombInfo[nr][nc] == -9)
					continue;
				int cur = bombInfo[nr][nc];
				bombInfo[nr][nc] = -9;
				DAT[cur][0] = -9;
				DAT[cur][1] = -9;
				cnt ++;
			}
			if (cnt == n*n) break;
		}

		System.out.println(ans + "초");
	}
}