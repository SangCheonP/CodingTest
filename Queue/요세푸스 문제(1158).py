from sys import stdin

N, K = map(int, stdin.readline().split())

num = 0 #제거할 대상 인덱스
result = [] #제거한 대상 추가할 리스트

temp =[i for i in range(1, N+1)]

while len(temp) > 0:
  num += K-1
  if num >= len(temp):
    num %= len(temp)
  result.append(str(temp.pop(num)))

print('<',", ".join(result),'>', sep='')