from sys import stdin
from itertools import combinations

def dfs(index, sum):
    global count
    if index >= N:
        return
    sum += arr[index]
    if sum == S:
        count += 1
    dfs(index+1, sum-arr[index]) # 해당원소 포함X
    dfs(index+1, sum) # 해당원소 포함
N, S = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))
count = 0
dfs(0,0)
print(count)