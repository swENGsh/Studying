from collections import deque
import sys

def bfs(find):
    cnt = 1
    while q:
        cr, cc = q.popleft()
        visited[cr][cc] = 1
        for k in range(4):
            nr, nc = cr + dr[k], cc + dc[k]
            if 0 <= nr < n and 0 <= nc < m and visited[nr][nc] == 0 and info[nr][nc] == find:
                q.append((nr, nc))
                visited[nr][nc] = 1
                cnt += 1
    return cnt

input = sys.stdin.readline
n, m = map(int, input().split())
info = list(list(input()) for _ in range(n))
visited = list([0]*m for _ in range(n))
dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]

q = deque()

max_val = 0
a_cnt = 0
b_cnt = 0
for i in range(n):
    for j in range(m):
        if info[i][j] != "_" and visited[i][j] == 0:
            q.append((i, j))
            c_cnt = bfs(info[i][j])
            max_val = max(c_cnt, max_val)
            if info[i][j] == 'A':
                a_cnt += 1
            elif info[i][j] == 'B':
                b_cnt += 1

print(a_cnt, b_cnt)
print(max_val)