from collections import deque

n, m = map(int, input().split())
course = list(list(map(int, input().split())) for _ in range(n))
waypoint = list(list(map(int, input().split())) for _ in range(n))
node = []
for i in range(n):
    for j in range(m):
        if waypoint[i][j]:
            node.append([i, j])

# 이분 탐색
start = 1
end = 1000000001
answer = end

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while start != end:
    mid = (start + end) // 2
    q = deque(node[0])
    visited = list([False] * m for _ in range(n))
    visited[node[0][0]][node[0][1]] = True
    while q:
        r, c = q.popleft()
        if r ==