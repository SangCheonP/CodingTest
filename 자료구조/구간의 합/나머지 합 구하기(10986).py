import sys
input = sys.stdin.readline
n, m = map(int, input().split())
A = list(map(int, input().split()))
S = [0] * n
C = [0] * m
answer = 0
S[0] = A[0]

for i in range(1, n): # 합 배열 저장
    S[i] = S[i-1] + A[i]

for i in range(n): # 합 배열을 m으로 나눈 나머지 값
    remainder = S[i]%m
    if (remainder == 0):
        answer += 1
    C[remainder] += 1

for i in range(0, m): # i가 나머지인 인덱스의 개수에서 2개를 뽑는 경우의 수 더하기
    temp = C[i] * (C[i]-1) / 2
    answer += int(temp)

print(answer)