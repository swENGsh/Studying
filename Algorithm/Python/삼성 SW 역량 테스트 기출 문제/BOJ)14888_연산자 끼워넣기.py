def calc(num, idx, operator, cnt):
    global n, maxval, minval
    if cnt == n:
        maxval = max(maxval, num)
        minval = min(minval, num)
        return
    else :
        if operator[0] > 0:
            operator[0] -= 1
            calc(num + nums[idx], idx+1, operator, cnt+1)
            operator[0] += 1
        if operator[1] > 0:
            operator[1] -= 1
            calc(num - nums[idx], idx+1, operator, cnt+1)
            operator[1] += 1
        if operator[2] > 0:
            operator[2] -= 1
            calc(num * nums[idx], idx+1, operator, cnt+1)
            operator[2] += 1
        if operator[3] > 0:
            operator[3] -= 1
            calc(int(num / nums[idx]), idx+1, operator, cnt+1)
            operator[3] += 1


n = int(input())
nums = list(map(int, input().split()))
oper = list(map(int, input().split())) # 덧셈, 뺄셈, 곱셈, 나눗셈
maxval = -1000000000
minval = 1000000000

calc(nums[0], 1, oper, 1)

print(maxval)
print(minval)