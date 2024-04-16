n = int(input())
arr = [[0,0]]*(n+1)
for i in range(n):
    time, pay = map(int, input().split())
    arr[i] = [time, pay]
dp = [0] * (n+1)
for i in range(n-1, -1, -1):
    if arr[i][0] + i > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+arr[i][0]] + arr[i][1], dp[i+1])
print(dp[0])