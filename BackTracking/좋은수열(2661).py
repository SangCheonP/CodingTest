# 입력받은 자릿수만큼의 길이가 될 때까지 깊이 우선 탐색을 진행하게 된다.
# 깊이 우선 탐색만 예를 들면 n = 7일 경우 첫 결과는 1111111이 된다. (최솟값 우선 조건 적용)
# 하지만 백트래킹 알고리즘을 적용하여 깊이 우선 탐색에 조건을 걸게 된다.
# 첫 번째 자리가 1이고 두 번째 자리가 1인 경우  나쁜 수열이 된다.
# 두 번째 자리에서 1을 선택하는 경우를 깊이 우선 탐색에서 제외한다면
# 1111111 ~ 121111111의 경우를 모두 제외시킬 수 있다.

from sys import stdin

N = int(stdin.readline())
s = []
def dfs(idx): # idx는 길이
    for i in range(1, idx//2+1):
        if s[-i:] == s[-i*2:-i]:
            return -1
    if idx == N:
        for i in range(N):
            print(s[i], end='')
        return 0
    for i in range(1, 4):
        s.append(i)
        if dfs(idx + 1) == 0:
            return 0
        s.pop()

dfs(0)