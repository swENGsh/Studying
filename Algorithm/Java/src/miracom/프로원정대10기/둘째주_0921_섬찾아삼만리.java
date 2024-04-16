package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 둘째주_0921_섬찾아삼만리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
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
	
	static void bfs() {
		while (!q.isEmpty()){
			Node node = q.poll();
			visited[node.y][node.x] = true;
			for (int k = 0; k < 4; k++) {
				int nr, nc;
				nr = node.y + dr[k];
				nc = node.x + dc[k];
				if (0 <= nr && nr < n && 0 <= nc && nc < m && visited[nr][nc] == false && map[nr][nc] == 1) {
					Node n_node = new Node(nr, nc);
					q.add(n_node);
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		map = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		q = new ArrayDeque<>();
		int cnt = 0;
		
		for (int i = 0; i< n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					Node node = new Node(i, j);
					q.add(node);
					bfs();
					cnt ++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
