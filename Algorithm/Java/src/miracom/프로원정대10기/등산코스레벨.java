package miracom.프로원정대10기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 등산코스레벨 {
	static int N, M;
	static int[][] heights;
	static int[][] waypoints;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		heights = new int[N][M];
		waypoints = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				waypoints[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<int[]> waypointCoords = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (waypoints[i][j] == 1) {
					waypointCoords.add(new int[] { i, j });
				}
			}
		}

		int minLevel = 0;

		for (int i = 0; i < waypointCoords.size(); i++) {
			for (int j = i + 1; j < waypointCoords.size(); j++) {
				int[] start = waypointCoords.get(i);
				int[] end = waypointCoords.get(j);
				int level = binarySearch(start[0], start[1], end[0], end[1]);

				minLevel = Math.max(minLevel, level);
			}
		}

		System.out.println(minLevel);
	}

	static int binarySearch(int start_x, int start_y, int end_x, int end_y) {
		int left = 0;
		int right = Math.abs(heights[start_x][start_y] - heights[end_x][end_y]);

		while (left < right) {
			int mid = (left + right) / 2;
			boolean connected = isConnected(mid);

			if (connected) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	static boolean isConnected(int level) {
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (waypoints[i][j] == 1 && !visited[i][j]) {
					if (!bfs(i, j, level, visited)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	static boolean bfs(int start_x, int start_y, int level, boolean[][] visited) {
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		List<int[]> queue = new ArrayList<>();
		queue.add(new int[] { start_x, start_y });

		while (!queue.isEmpty()) {
			int[] current = queue.remove(0);
			int x = current[0];
			int y = current[1];

			if (waypoints[x][y] == 1) {
				visited[x][y] = true;
			}

			for (int[] dir : dirs) {
				int nx = x + dir[0];
				int ny = y + dir[1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					int levelDiff = Math.abs(heights[x][y] - heights[nx][ny]);

					if (levelDiff <= level) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (waypoints[i][j] == 1 && !visited[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
