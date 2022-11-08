import sys
str1 = list(sys.stdin.readline().rstrip())
str2 = []

for _ in range(int(sys.stdin.readline())):
    command = sys.stdin.readline().split()
    if command[0] == 'L':
        if str1:
            str2.append(str1.pop())
    elif command[0] == 'D':
        if str2:
            str1.append(str2.pop())
    elif command[0] == 'B':
        if str1:
            str1.pop()
    else:
        str1.append(command[1])
str1.extend(reversed(str2))
print(''.join(str1))