from collections import deque
import sys

def bfs():
    while q:
        cr, cc = q.popleft()
        visited[cr][cc] = 1
        for k in range(4):
            nr, nc = cr + dr[k], cc + dc[k]
            if 0 <= nr < n and 0 <= nc < m and visited[nr][nc] == 0 and island[nr][nc] == 1:
                    q.append((nr, nc))
                    visited[nr][nc] = 1

input = sys.stdin.readline
n, m = map(int, input().split())
island = list(list(map(int, input().split())) for _ in range(n))
visited = list([0] * m for _ in range(n))
dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]
cnt = 0

q = deque()

for i in range(n):
    for j in range(m):
        if island[i][j] and visited[i][j] == 0:
            q.append((i, j))
            bfs()
            cnt += 1

print(cnt)