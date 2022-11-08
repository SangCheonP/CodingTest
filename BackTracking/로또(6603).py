from sys import stdin
from itertools import combinations

while True:
    temp = list(map(int, stdin.readline().split()))
    K = temp[:1]
    S = temp[1:]
    if K[0] == 0:
        break
    result = list(combinations(S, 6))
    for i in result:
        for j in i:
            print(j, end=' ')
        print()
    print()