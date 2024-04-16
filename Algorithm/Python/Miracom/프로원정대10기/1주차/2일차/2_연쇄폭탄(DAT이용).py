n = int(input())
bomb_info = [list(map(int, input().split())) for _ in range(n)]
DAT = [[] for _ in range(n*n+1)]
dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]
ans = 0

for i in range(n):
    for j in range(n):
        DAT[bomb_info[i][j]] = [i, j]

for i in range(1, n*n+1):
    if DAT[i] == []: continue
    ans = i
    r, c = DAT[i]
    bomb_info[r][c] = -9
    DAT[i] = []
    for k in range(4):
        nr, nc = r + dr[k], c + dc[k]
        if 0 <= nr < n and 0 <= nc < n and bomb_info[nr][nc] != -9:
            cur = bomb_info[nr][nc]
            bomb_info[nr][nc] = -9
            DAT[cur] = []

print(f"{ans}초")