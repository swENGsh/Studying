n = int(input())
students = list(map(int, input().split()))
b, c = map(int, input().split())
ans = n
for i in range(n):
    if students[i] > b:
        rem = students[i] - b
        if rem % c == 0:
            ans += rem // c + 1
        else :
            ans += rem // c + 1

print(ans)