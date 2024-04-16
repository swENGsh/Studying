import sys
input = sys.stdin.readline
# 입력 받기
N, M = map(int, input().split())
heights = []
waypoints = []

for _ in range(N):
    heights.append(list(map(int, input().split())))

for _ in range(N):
    waypoints.append(list(map(int, input().split())))

# 웨이포인트의 좌표 저장
waypoint_coords = []

for i in range(N):
    for j in range(M):
        if waypoints[i][j] == 1:
            waypoint_coords.append((i, j))


# 이분 탐색 함수 정의
def binary_search(start_x, start_y, end_x, end_y):
    left, right = 0, abs(heights[start_x][start_y] - heights[end_x][end_y])

    while left < right:
        mid = (left + right) // 2
        # mid 레벨 차이로 모든 웨이포인트 쌍이 연결 가능한지 확인
        connected = is_connected(mid)
        if connected:
            right = mid
        else:
            left = mid + 1

    return left


# BFS 함수 정의
def bfs(start_x, start_y, end_x, end_y, level):
    visited = [[False] * M for _ in range(N)]
    queue = [(start_x, start_y)]
    visited[start_x][start_y] = True

    while queue:
        x, y = queue.pop(0)

        # 목적지에 도달한 경우
        if x == end_x and y == end_y:
            return True

        # 상하좌우 이동
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                level_diff = abs(heights[x][y] - heights[nx][ny])

                if level_diff <= level:
                    queue.append((nx, ny))
                    visited[nx][ny] = True

    return False


# 모든 웨이포인트 쌍에 대한 최소 레벨 찾기
def is_connected(level):
    for i in range(len(waypoint_coords)):
        for j in range(i + 1, len(waypoint_coords)):
            start_x, start_y = waypoint_coords[i]
            end_x, end_y = waypoint_coords[j]

            if not bfs(start_x, start_y, end_x, end_y, level):
                return False

    return True


# 모든 웨이포인트 쌍에 대해 최소 레벨 찾기
min_level = 0
for i in range(len(waypoint_coords)):
    for j in range(i + 1, len(waypoint_coords)):
        start_x, start_y = waypoint_coords[i]
        end_x, end_y = waypoint_coords[j]
        level = binary_search(start_x, start_y, end_x, end_y)
        min_level = max(min_level, level)

# 결과 출력
print(min_level)
