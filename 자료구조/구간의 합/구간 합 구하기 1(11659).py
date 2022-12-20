import sys
input = sys.stdin.readline
n, q = map(int, input().split())
numbers = list(map(int, input().split()))
prefix_sum = [0]
temp = 0

for i in numbers:
    temp += i
    prefix_sum.append(temp)

for i in range(q):
    n1, n2 = map(int, input().split())
    print(prefix_sum[n2]-prefix_sum[n1-1])