# 0은 괴물 O
# 1은 괴물 X

# 5 6
# 101010
# 111111
# 000001
# 111111
# 111111

# 10

from collections import deque

# N, M을 공백을 기준으로 구분하여 입력 받기
N, M = map(int, input().split())
# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(N):
    graph.append(list(map(int, input())))

# 이동할 네가지 방향 정의
#    (좌, 우, 하, 상)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    # 큐 구현을 위해 deque 라이브러리 사용
    queue = deque() # 이동방향 : <-
    queue.append((x, y))
    # 큐가 빌 때까지 반복하기
    while queue:
        x, y = queue.popleft()
        # 현재 위치에서 4가지 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 미로 찾기 공간을 벗어난 경우 무시
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            # 벽(괴물)인 경우 무시
            if graph[nx][ny] == 0:
                continue
            # 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if graph[nx][ny] == 1:
                # 바로 직전 노드에서의 최단 거리 값에 1을 더한 값을 현재 노드에 기록
                graph[nx][ny] = graph[x][y] + 1
                # 큐에 data를 넣으로서 거리 값을 1 증가시킬 수 있다.
                queue.append((nx, ny))
    # 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[N-1][M-1]

print(bfs(0, 0))