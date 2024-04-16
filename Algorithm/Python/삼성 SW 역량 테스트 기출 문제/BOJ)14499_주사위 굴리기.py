def change_dice(dice, k):
    ndice = [0] * 6
    if k == 1:
        ndice[0] = dice[0]
        ndice[5] = dice[1]
        ndice[1] = dice[2]
        ndice[2] = dice[3]
        ndice[4] = dice[4]
        ndice[3] = dice[5]
    elif k == 2:
        ndice[0] = dice[0]
        ndice[2] = dice[1]
        ndice[3] = dice[2]
        ndice[5] = dice[3]
        ndice[4] = dice[4]
        ndice[1] = dice[5]
    elif k == 3:
        ndice[2] = dice[0]
        ndice[1] = dice[1]
        ndice[4] = dice[2]
        ndice[3] = dice[3]
        ndice[5] = dice[4]
        ndice[0] = dice[5]
    elif k == 4:
        ndice[5] = dice[0]
        ndice[1] = dice[1]
        ndice[0] = dice[2]
        ndice[3] = dice[3]
        ndice[2] = dice[4]
        ndice[4] = dice[5]
    dice = ndice
    return dice
n, m, r, c, k = map(int, input().split())
MAP = [[0]*m for _ in range(n)]
# dice : 0 1 2 3 4 5 인덱스로 이용할거
dice = [0, 0, 0, 0, 0, 0] # 초기값
# map 정보
for i in range(n):
    cols = list(map(int, input().split()))
    for j in range(m):
        MAP[i][j] = cols[j]
# 명령 => 방향으로만
# 1 동 2 서 3 북 4 남
orders = list(map(int, input().split()))
dr, dc = [0, 0, -1, 1], [1, -1, 0, 0]
if MAP[r][c] == 0:
    MAP[r][c] = dice[5]
else:
    dice[5] = MAP[r][c]
for k in orders:
    nr, nc = r + dr[k-1], c + dc[k-1]
    if 0 > nr or n <= nr or 0 > nc or m <= nc:
        continue
    dice = change_dice(dice, k)
    # 주사위 좌표 : 뒤 왼 위 오 앞 바닥
    if MAP[nr][nc] == 0:
        MAP[nr][nc] = dice[5]
    else:
        dice[5] = MAP[nr][nc]
        MAP[nr][nc] = 0
    r, c = nr, nc
    print(dice[2])