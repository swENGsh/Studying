package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 둘째주_0921_미생물관찰 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static char[][] info;
	static boolean[][] visited;
	static ArrayDeque<Node> q;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int bfs(char find) {
		int cnt = 1;
		while (!q.isEmpty()){
			Node node = q.poll();
			visited[node.y][node.x] = true;
			for (int k = 0; k < 4; k++) {
				int nr, nc;
				nr = node.y + dr[k];
				nc = node.x + dc[k];
				if (0 <= nr && nr < n && 0 <= nc && nc < m && visited[nr][nc] == false && info[nr][nc] == find) {
					Node n_node = new Node(nr, nc);
					q.add(n_node);
					visited[nr][nc] = true;
					cnt ++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		info = new char[n][m];
		for (int i=0; i<n; i++) {
			info[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[n][m];
		q = new ArrayDeque<>();
		int max = 0;
		int a_cnt = 0;
		int b_cnt = 0;
		
		for (int i =0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (info[i][j] != '_' && visited[i][j] == false) {
					Node node = new Node(i, j);
					q.add(node);
					int c_cnt = bfs(info[i][j]);
					max = Math.max(max, c_cnt);
					if (info[i][j] == 'A') a_cnt ++;
					else if (info[i][j] == 'B') b_cnt ++;
				}
			}
		}
		System.out.println(a_cnt + " " + b_cnt);
		System.out.println(max);
	}
}