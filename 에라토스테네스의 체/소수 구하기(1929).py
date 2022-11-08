from sys import stdin

M, N = map(int, stdin.readline().split())


def isPrime(n):
    if n == 1:
        return False
    else:
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True


for i in range(M, N + 1):
    if isPrime(i):
        print(i)