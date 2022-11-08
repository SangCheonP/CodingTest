from sys import stdin
for _ in range(int(stdin.readline())):
  count = 0 #몇번째 출력되는지
  N, K = map(int, stdin.readline().split())
  imp = list(map(int, stdin.readline().split())) #중요도
  idx = list(range(len(imp))) #고유 인덱스 저장
  idx[K] = 'target'

  while True:
    if imp[0] == max(imp):
      count += 1
      if idx[0] == 'target':
        print(count)
        break
      else:
        imp.pop(0)
        idx.pop(0)
    else:
      imp.append(imp.pop(0))
      idx.append(idx.pop(0))