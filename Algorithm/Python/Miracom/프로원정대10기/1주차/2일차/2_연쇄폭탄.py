n = int(input())
bomb_info = [list(map(int, input().split())) for _ in range(n)]
bomb_lst = list(range(1, n*n + 1))
dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]
ans = 0

while bomb_lst:
    cur = bomb_lst[0]
    ans = cur
    flag = False
    for r in range(n):
        if flag:
            break
        for c in range(n):
            if flag:
                break
            if bomb_info[r][c] == cur:
                bomb_info[r][c] = -9
                bomb_lst.remove(cur)
                for k in range(4):
                    nr, nc = r + dr[k], c + dc[k]
                    if 0<=nr<n and 0<=nc<n and bomb_info[nr][nc] != -9:
                        cur = bomb_info[nr][nc]
                        bomb_info[nr][nc] = -9
                        bomb_lst.remove(cur)
                flag = True

print(f"{ans}초")