from sys import stdin

N = int(stdin.readline()) # 가로수 수
garosu = [] # 가로수 리스트
space = [] # 가로수 사이의 간격 리스트
gap = 0 # 가로수 사이의 최소 간격
result = 0 # 결과값

for i in range(N):
    garosu.append(int(stdin.readline())) # 가로수 수만큼 입력받아 리스트에 저장

for j in range(1,N):
    space.append(garosu[j]-garosu[j-1]) # 가로수 사이 간격 계산
gap = min(space)

for i in range(garosu[0], garosu[N-1]+1, gap):
    if i not in garosu:
        result += 1

print(result)