package miracom.프로원정대10기.첫째주._1일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1_폭탄투하 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		char[][] arr = new char[4][5];
		for (int i=0; i<4; i++) {
			for (int j=0; j<5; j++) {
				arr[i][j] = '_';
			}
		}
		int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for (int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int k=0; k<8; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (0>nr || 4<=nr || 0 >nc || 5<=nc) continue;
				arr[nr][nc] = '#';
			}
		}
		
		for (int i=0; i<4; i++) {
			for (char c: arr[i]) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
}