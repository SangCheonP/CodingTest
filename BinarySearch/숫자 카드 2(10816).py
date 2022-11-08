from sys import stdin

N = int(stdin.readline())
a = sorted(list(map(int, stdin.readline().split())))

M = int(stdin.readline())
b = list(map(int, stdin.readline().split()))

count = {}

for i in a:
    if i in count:
        count[i] += 1
    else:
        count[i] = 1

for target in b:
    result = count.get(target)
    if result == None:
        print(0, end=" ")
    else:
        print(result, end=" ")