from sys import stdin

def check(level):
    for i in range(level):
        if col[i] == col[level] or abs(col[level] - col[i]) == level - i:
            return False
    return True

def nqueen(x): # dfs
    global total
    if x == N: # n번째 행까지 이동하면, 겹치지 않게 놓았다는 의미
        total += 1
        return
    for i in range(N):
        if visited[i]:
            continue
        col[x] = i # [x,i]에 놓겠다
        if(check(x)): # 만약, 놓다 True가 되면 그곳에 놓고, 다음 열로 넘어감
            visited[i]=True
            nqueen((x+1))
            visited[i]=False

N = int(stdin.readline())
total = 0
col = [0]*N
visited = [False]*N

nqueen(0)
print(total)