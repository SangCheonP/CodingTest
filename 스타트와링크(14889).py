from sys import stdin

N = stdin.readline()
status = []

for i in range(N):
    status.append(list(map(int, stdin.readline().split(''))))

print(status)