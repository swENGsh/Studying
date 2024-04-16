from collections import deque
def move(r, c):
    global cd, time
    area[r][c] = 1
    while True:
        time += 1
        nr, nc = r + dr[cd], c + dc[cd]
        if 0 > nr or nr >= n or 0 > nc or nc >= n or (nr, nc) in tails:
            return
        if area[nr][nc] != 2:
            tr, tc = tails.popleft()
            area[tr][tc] = 0
        r, c = nr, nc
        area[r][c] = 1
        tails.append((r, c))
        if time in info:
            ct = info.pop(time)
            cd = (ct+cd+4) % 4

n = int(input())
k = int(input())
area = [[0]*n for _ in range(n)]
for i in range(k):
    r, c = map(int, input().split())
    area[r-1][c-1] = 2
l = int(input())
info = {}
for i in range(l):
    x, c = input().split()
    if c == 'D':
        info[int(x)] = 1
    elif c == 'L':
        info[int(x)] = -1

# 오, 아, 왼, 위
dr, dc = [0, 1, 0, -1], [1, 0, -1, 0]
# 현재 방향
cd = 0
# 현재 시간
time = 0
# 현재 꼬리 위치 큐로 구현 => 사과가 있으면 꼬리 늘어남
tails = deque()
tails.append((0, 0))
move(0, 0)
print(time)