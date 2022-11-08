from sys import stdin
N = int(stdin.readline())
count = N
result = list()
result.extend(map(int, stdin.readline().split()))

for i in result:
    check = True
    if i == 1:
        check = False
    else:
        for j in range(2, i):
            if i % j == 0:
                check = False
    if check == False:
        count -= 1

print(count)