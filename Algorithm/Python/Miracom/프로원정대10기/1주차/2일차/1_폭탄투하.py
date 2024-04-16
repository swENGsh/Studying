arr = [['_']*5 for _ in range(4)]
dr, dc = [-1, -1, 0, 1, 1, 1, 0, -1], [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(2):
    r, c = map(int, input().split())
    for k in range(8):
        nr, nc = r + dr[k], c + dc[k]
        if 0 <= nr < 4 and 0 <= nc < 5:
            arr[nr][nc] = '#'

for i in range(4):
    print(*arr[i])