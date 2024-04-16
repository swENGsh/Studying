from collections import deque
import sys
def bfs():
    visited = list([0]*5 for _ in range(5))
    while q:
        r, c = q.popleft()
        visited[r][c] = 1
        for k in range(4):
            nr, nc = r + dx[k], c + dy[k]
            if 0 <= nr < 5 and 0 <= nc < 5 and visited[nr][nc] == 0:
                q.append((nr, nc))
                arr[nr][nc] = arr[r][c] + 1
                visited[nr][nc] = 1
input = sys.stdin.readline
x, y = map(int, input().split())
arr = list([0]*5 for _ in range(5))
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
arr[x][y] = 1

q = deque()
q.append((x, y))
bfs()

for i in range(5):
    print(*arr[i])
