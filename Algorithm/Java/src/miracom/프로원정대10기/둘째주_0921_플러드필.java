package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 둘째주_0921_플러드필 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
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
		boolean[][] visited = new boolean[5][5];
		while (!q.isEmpty()){
			Node node = q.poll();
			visited[node.y][node.x] = true;
			for (int k = 0; k < 4; k++) {
				int nr, nc;
				nr = node.y + dr[k];
				nc = node.x + dc[k];
				if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && visited[nr][nc] == false) {
					Node n_node = new Node(nr, nc);
					q.add(n_node);
					map[nr][nc] = map[node.y][node.x] + 1;
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		map = new int[5][5];
		map[y][x] = 1;
		
		q = new ArrayDeque<>();
		Node node = new Node(y, x);
		q.add(node);
		bfs();
		
		for (int i = 0; i< 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
