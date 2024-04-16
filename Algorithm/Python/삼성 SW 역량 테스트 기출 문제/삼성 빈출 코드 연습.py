#1-1. 회전 : zip 활용
arr = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
# 시계방향으로 90도 회전
arr90 = list(map(list, zip(*arr[::-1])))
print(arr90)
# 시계방향으로 180도 회전
arr180 = [a[::-1] for a in arr[::-1]]
print(arr180)
# 반시계방향으로 90도 회전
arr270 = [x[::-1] for x in list(map(list, zip(*arr[::-1])))[::-1]]
print(arr270)

#1-2. 회전 : 인덱스 규칙 활용
## 정사각형
n = 4
narr90 = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        narr90[j][n-i-1] = arr[i][j]
print(narr90)
narr180 = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        narr180[n-i-1][n-j-1] = arr[i][j]
print(narr180)
narr270 = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        narr270[n-j-1][i] = arr[i][j]
print(narr270)

## 직사각형 n*m 행렬 -> 3*4
lectengle = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
n, m = len(lectengle), len(lectengle[0])
larr90 = [[0]*n for _ in range(m)]
for i in range(n):
    for j in range(m):
        larr90[j][n-i-1] = lectengle[i][j]
print(larr90)
larr180 = [[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        larr180[n-i-1][m-j-1] = lectengle[i][j]
print(larr180)
larr270 = [[0]*n for _ in range(m)]
for i in range(n):
    for j in range(m):
        larr270[m-j-1][i] = lectengle[i][j]
print(larr270)

#2, 부분 회전
## 7x7 행렬 -> (2, 2) 위치에 있는 3x3 행렬 회전
arr = [[7 * j + i for i in range(1, 8)] for j in range(7)]
narr = [[0]*7 for _ in range(7)]
sr, sc = 2, 2
length = 3
def rotate90(sr, sc, length):
    r90 = arr
    for r in range(sr, sr+length):
        for c in range(sc, sc+length):
            #1단계 : (0, 0)으로 대칭이동 (0,0) 화 시키기
            qr, qc = r - sr, c - sc
            nr, nc = qc, length - qr - 1
            narr[nr+sr][nc+sc] = arr[r][c]
    for r in range(sr, sr + length):
        for c in range(sc, sc + length):
            r90[r][c] = narr[r][c]
    return r90
print(rotate90(sr, sc, length))

#3. 순열, 중복 순열, 조합, 중복 조합
arr = [1, 2, 3, 4]
## 순열 => 순서 o, 중복 x
visited = [0] * len(arr)
ans1 = []
def perm(n, narr):
    if len(narr) == n:
        ans1.append(narr)
        return
    for i in range(len(arr)):
        if not visited[i]:
            visited[i] = 1
            perm(n, narr + [arr[i]])
            visited[i] = 0
perm(2, [])
print(ans1)

## 중복 순열 => 순서 o 중복 o
ans2 = []
def product(n, narr):
    if len(narr) == n:
        ans2.append(narr)
        return
    for i in range(len(arr)):
        product(n, narr+[arr[i]])
product(2, [])
print(ans2)

## 조합 => 순서 x, 중복 x
ans3 = []
def comb(n, narr, c):
    if len(narr) == n:
        ans3.append(narr)
        return
    for i in range(c, len(arr)):
        comb(n, narr+[arr[i]], i+1)
comb(2, [], 0)
print(ans3)

## 중복 조합 => 순서x, 중복 o
ans4 = []
def comb_replace(n, narr, c):
    if len(narr) == n:
        ans4.append(narr)
        return
    for i in range(c, len(arr)):
        comb_replace(n, narr + [arr[i]], i)
comb_replace(2, [], 0)
print(ans4)

#4. 중력
arr = [[0, 1, 0],
       [1, 0, 1],
       [0, 1, 0],
       [0, 0, 1],
       [0, 1, 0]]
def gravity():
    n = len(arr)
    m = len(arr[0])
    for i in range(n-1):
        for j in range(m):
            p = i
            while 0 <= p and arr[p][j] == 1 and arr[p+1][j] == 0:
                arr[p][j], arr[p+1][j] = arr[p+1][j], arr[p][j]
                p -= 1
gravity()
print(arr)

#5. 달팽이(나선형) 배열
## 안에서 밖으로
arr = [[0] * 5 for _ in range(5)]
def tornado():
    # 왼, 아, 오, 위 순서
    dr, dc = [0,1,0,-1], [-1,0,1,0]
    r = c = len(arr) // 2
    num = 0
    dist = 1
    d_idx = 0
    move_count = 0  # 2가 되면 dist 길이가 1 늘어나고 move_count는 다시 0으로 초기화
    while True:
        for _ in range(dist):
            nr, nc = r + dr[d_idx], c + dc[d_idx]
            if (nr, nc) == (0, -1):  # 0행 -1열이 토네이도가 모두 끝나고 나서의 위치임
                return
            num += 1
            arr[nr][nc] = num
            y = nr
            x = nc
        move_count += 1
        d_idx = (d_idx + 1) % 4
        if move_count == 2:
            dist += 1
            move_count = 0

tornado()

## 밖에서 안으로
def solution(n):
    if n == 1:
        return [[1]]

    answer = [[0 for j in range(n)] for i in range(n)]  # 배열 초기화

    r = 0
    c = 0
    d_idx=0

    for i in range(n * n):
        answer[r][c] = i + 1
        if d_idx == 0:
            c += 1
            if c == n - 1 or answer[r][c + 1] != 0:
                d_idx = 1
        elif d_idx == 1:
            r += 1
            if r == n - 1 or answer[r + 1][c] != 0:
                d_idx = 2
        elif d_idx == 2:
            c -= 1
            if c == 0 or answer[r][c - 1] != 0:
                d_idx = 3
        elif d_idx == 3:
            r -= 1
            if r == n - 1 or answer[r - 1][c] != 0:
                d_idx = 0
    return answer

arr = solution(5)
print(arr)