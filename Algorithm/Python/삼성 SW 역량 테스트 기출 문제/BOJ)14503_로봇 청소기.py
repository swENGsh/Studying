from collections import deque
def start_vacuum():
    cnt = 0
    while q:
        cr, cc, cd = q.popleft()
        if area[cr][cc] == 0:
            area[cr][cc] = 2
            cnt += 1
        turn = 0
        for i in range(4):
            nd = cd - 1 if cd > 0 else 3
            nr, nc = cr + dr[nd], cc + dc[nd]
            cd = nd
            if 0 <= nr < n and 0 <= nc < m and area[nr][nc] == 0:
                q.append((nr, nc, nd))
                break
            else:
                turn += 1
        if turn == 4:
            nr, nc = cr - dr[cd], cc - dc[cd]
            if area[nr][nc] == 1: return cnt
            q.append((nr, nc, cd))

    return cnt
n, m = map(int, input().split())
r, c, d = map(int, input().split())
area = [list(map(int, input().split())) for _ in range(n)]
dr, dc = [-1, 0, 1, 0], [0, 1, 0, -1]

q = deque()
q.append((r, c, d))
print(start_vacuum())
