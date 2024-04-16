package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 둘째주_0920_웜바이러스 {
	static int cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] virus;

	private static void BFS(int x) {
		
		for (int i : virus[x]) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			cnt ++;
			BFS(i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int com = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		virus = new ArrayList[com + 1];
		for (int i = 1; i <= com; i++) {
			virus[i] = new ArrayList<>();
		}
		visited = new boolean[com + 1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			virus[a].add(b);
			virus[b].add(a);
		}
		visited[1] = true;
		BFS(1);
		sb.append(cnt);
		System.out.println(sb);
	}
}