import sys
sys.setrecursionlimit(2000)

def dfs(x):
    visited[x] = 1 # 방문한 곳 1로 표시
    next = arr[x]
    if visited[next] == 0: # 아직 방문하지 않은 곳인 경우
        dfs(next)

for _ in range(int(input())):
    result = 0
    N = int(input())
    arr = [0] + list(map(int, input().split()))
    visited = [0] * (N+1)

    for i in range(1, N+1):
        if visited[i] == 0:
            dfs(i)
            result += 1 # 한 사이클이 완성되면 1추가

    print(result)
