import sys
a = []
b = []
n = int(sys.stdin.readline())

a.extend(map(int, sys.stdin.readline().split()))
b.extend(map(int, sys.stdin.readline().split()))

c=b
a.sort()
c.sort()
sum = 0
for i in range(n):
    sum += a[i]*c[-(i+1)]
print(sum)