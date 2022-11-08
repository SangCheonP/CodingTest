from sys import stdin
temp = []
op = []
count = 1
state = True
for _ in range(int(stdin.readline())):
  num = int(stdin.readline())
  while count <= num:
    temp.append(count)
    op.append('+')
    count += 1
  if temp[-1] == num:
    temp.pop()
    op.append('-')
  else:
    state = False
if state == True:
  for i in op:
    print(i)
else:
  print('NO')