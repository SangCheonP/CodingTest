import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))
A.sort()
Result = 0

for k in range(n):
    find = A[k]
    i = 0
    j = n - 1
    while i < j:
        if A[i] + A[j] == find:
            if i != k and j != k: # find는 서로 다른 두 수의 합이여야함
                Result += 1
                break;
            elif i == k:
                i += 1
            elif j == k:
                j -= 1
        elif A[i] + A[j] > find:
            j -= 1
        elif A[i] + A[j] < find:
            i += 1

print(Result)