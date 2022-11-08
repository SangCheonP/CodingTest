import sys
t = int(sys.stdin.readline())
arr = []

for i in range(t):
    str = sys.stdin.readline().split()
    if str[0] == 'push_front':
        arr.insert(0, str[1])
    elif str[0] == 'push_back':
        arr.append(str[1])
    elif str[0] == 'pop_front':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop(0))
    elif str[0] == 'pop_back':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop(-1))
    elif str[0] == 'size':
        print(len(arr))
    elif str[0] == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
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