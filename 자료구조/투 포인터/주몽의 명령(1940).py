import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
A = list(map(int, input().split()))
A.sort()
i = 0
j = n - 1
count = 0

while i < j:
    if A[i] + A[j] == m:
        count += 1
        i += 1
        j -= 1
    elif A[i] + A[j] > m:
        j -= 1
    elif A[i] + A[j] < m:
        i += 1

print(count)