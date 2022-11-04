import sys
graph = []
blank = []

for i in range(9):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

# 빈칸만 따로 리스트로 만듦
for i in range(9):
    for j in range(9):
        if graph[i][j] == 0:
            blank.append((i, j))

# a가 행에 없는 수임을 확인
def checkRow(x, a):
    for i in range(9):
        if a == graph[x][i]:
            return False
    return True

# a가 열에 없는 수임을 확인
def checkCol(y, a):
    for i in range(9):
        if a == graph[i][y]:
            return False
    return True

# a가 정사각형에 없는 수임을 확인
def checkRect(x, y, a):
    # 0, 1, 2로 정사각형의 각 시작부분
    nx = x // 3 * 3
    ny = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if a == graph[nx+i][ny+j]:
                return False
    return True


def dfs(idx):
    if idx == len(blank):
        for i in range(9):
            print(*graph[i])
        exit(0)

    for i in range(1, 10):
        x = blank[idx][0]
        y = blank[idx][1]

        # i가 행, 열, 정사각형 모두에 없으면
        if checkRow(x, i) and checkCol(y, i) and checkRect(x, y, i):
            graph[x][y] = i
            dfs(idx+1)
            graph[x][y] = 0

dfs(0)
