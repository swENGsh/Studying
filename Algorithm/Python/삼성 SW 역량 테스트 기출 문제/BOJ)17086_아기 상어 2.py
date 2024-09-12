from collections import deque
def bfs():
    while q : 
        r, c = q.popleft()
        for k in range(8):
            nr, nc = r + dr[k], c + dc[k]
            if 0 > nr or nr >= n or 0 > nc or nc >= m: continue
            if area[nr][nc]: continue
            area[nr][nc] = area[r][c] + 1
            q.append((nr, nc))
    maxv = 0
    for arr in area:
        mxv = max(arr)
        maxv = max(mxv, maxv)
    return maxv - 1

n, m = map(int, input().split())
area = [list(map(int, input().split())) for _ in range(n)]
q = deque()
dr, dc = [-1, 1, 0, 0, -1, -1, 1, 1],[0, 0, -1, 1, -1, 1, -1, 1]

for i in range(n):
    for j in range(m):
        if area[i][j] == 1:
            q.append((i, j))

print(bfs())