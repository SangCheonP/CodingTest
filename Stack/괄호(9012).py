from sys import stdin

for j in range(int(stdin.readline())):
  list = stdin.readline().rstrip()
  temp = []

  for i in list:
    if i == '(':
      temp.append(i)
    elif i == ')':
      if temp:
        temp.pop()
      else:
        print('NO')
        break
  else:
    if temp:
      print('NO')
    else:
      print('YES')