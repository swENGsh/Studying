package miracom.프로원정대10기.첫째주._1일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2_연쇄폭탄 {
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
		List<Integer> bombList = new ArrayList<Integer>();
		for (int i = 0; i < n * n; i++) {
			bombList.add(i + 1);
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int ans = 0;

		while (!bombList.isEmpty()) {
			int cur = bombList.get(0);
			ans = cur;
			out: for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (bombInfo[r][c] == cur) {
						bombInfo[r][c] = -9;
						bombList.remove(Integer.valueOf(cur));
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (0 > nr || n <= nr || 0 > nc || n <= nc || bombInfo[nr][nc] == -9)
								continue;
							cur = bombInfo[nr][nc];
							bombInfo[nr][nc] = -9;
							bombList.remove(Integer.valueOf(cur));
						}
						break out;
					}
				}
			}
		}
		System.out.println(ans + "초");
	}
}