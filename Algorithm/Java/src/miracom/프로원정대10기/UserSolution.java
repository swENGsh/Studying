package miracom.프로원정대10기;

import java.util.ArrayDeque;

class UserSolution {
	
	static int[][] incubator;
	static int[][] visited;
	static ArrayDeque<Main.Result> q;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int id = 0;
	static int n;
	
    public void init(int N) {
    	n = N+1;
    	incubator = new int[N+1][N+1];
    	visited = new int[N+1][N+1];
    	q = new ArrayDeque<>();
    }

    public Main.Result putBacteria(int mTime, int mRow, int mCol, Main.Bacteria mBac) {
    	Main.Result ret = new Main.Result();
    	ret.row = mRow;
    	ret.col = mCol;
    	
    	q.add(ret);
    	
    	int cnt = 1;
    	int bac_time = mTime + mBac.time;
    	while(!q.isEmpty()) {
    		Main.Result node = q.poll();
			visited[node.row][node.col] = bac_time;
			for (int k = 0; k < 4; k++) {
				int nr, nc;
				nr = node.row + dr[k];
				nc = node.col + dc[k];
				if (0 < nr && nr < n && 0 < nc && nc < n && (visited[nr][nc] == 0 || visited[nr][nc] <= mTime)) {
					Main.Result n_node = new Main.Result();
					n_node.row = nr;
					n_node.col = nc;
					q.add(n_node);
					visited[nr][nc] = bac_time;
					cnt ++;
				}
			}
    	}
    	
    	if (cnt < mBac.size) {
    		for (int i=1; i<n; i++) {
    			for (int j=1; j<n; j++) {
    				if (visited[i][j] == bac_time)
    					visited[i][j] = 0;
    			}
    		}
    		ret = new Main.Result();
    		return ret;
    	}
        return ret;
    }
    
    public int killBacteria(int mTime, int mRow, int mCol) {
    	return 0; 
    }
    
    public int checkCell(int mTime, int mRow, int mCol) {
    	return 0;
    }
}