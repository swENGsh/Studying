import copy
from collections import deque
# 2번 6번만 판별하면 됨
def rotate_r(wnum, d):
    if wnum == 3:
        return
    if wheels[wnum][2] != wheels[wnum+1][6]:
        rotate_r(wnum+1, -d)
        wheels[wnum+1].rotate(d)

def rotate_l(wnum, d):
    if wnum == 0:
        return
    if wheels[wnum][6] != wheels[wnum - 1][2]:
        rotate_l(wnum - 1, -d)
        wheels[wnum - 1].rotate(d)

# 12시방향부터 시계방향으로 8개 => 각 리스트 0번 인덱스 값이 12시
# N극 : 0 / S극 : 1
wheels = [deque(list(map(int, input()))) for _ in range(4)]
k = int(input())
for i in range(k):
    # w => 톱니바퀴 번호, d => 1 : 시계방향 / -1 : 반시계방향
    w, d = map(int, input().split())
    w -= 1 # wheel 번호 -1 해줘야해서 미리 해줌.
    rotate_r(w, -d)
    rotate_l(w, -d)
    wheels[w].rotate(d)

ans = 0
for i in range(4):
    if wheels[i][0] == 1:
        ans += 2**i
print(ans)