a = int(input())
b = [1, 2, 4]
for i in range(3, 11):
    b += [b[i-3]+b[i-2]+b[i-1]]
for j in range(a):
    c = int(input())
    print((b[c-1]))