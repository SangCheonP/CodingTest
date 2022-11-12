from sys import stdin
from itertools import permutations

N = int(stdin.readline())
status = []
str = [1, 2, 3]
set = list(permutations(str, 2))

for i in range(N):
    status.append(list(map(int, stdin.readline().split())))

def cul(str, status): # 맴버 리스트를 받아 모든 조합의 합을 구하는 함수
    set = list(permutations(str, 2))
    result = 0
    for i in set:
        result += status[i[0]-1][i[1]-1]
    return result

print(cul(str, status))
print(set)
print(status[0])
print(status[1])
print(status[2])
print(status[3])
