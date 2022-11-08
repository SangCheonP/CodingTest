import sys
t = int(sys.stdin.readline())
arr = []

for i in range(t):
    str = list(sys.stdin.readline().split())
    if str[0] == 'push':
        arr.append(str[1])
    elif str[0] == 'front':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[0])
    elif str[0] == 'back':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
    elif str[0] == 'size':
        print(len(arr))
    elif str[0] == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif str[0] == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop(0))