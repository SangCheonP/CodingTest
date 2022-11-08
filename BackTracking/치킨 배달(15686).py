from sys import stdin
from itertools import combinations as cb

N, M = map(int, stdin.readline().split())
arr = [list(map(int, stdin.readline().split())) for _ in range(N)]
result = 9999999
chick = []
house = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append([i, j])
        elif arr[i][j] == 2:
            chick.append([i, j])

for i in cb(chick, M):
    temp = 0 # 도시 치킨 거리
    for h in house:
        chi_len = 999 # 치킨 거리
        for j in range(M):
            chi_len = min(chi_len, abs(h[0]-i[j][0]) + abs(h[1]-i[j][1])) # j 는 어떤 치킨집인지 리스트에 대해
        temp += chi_len
    result = min(result, temp)

print(result)