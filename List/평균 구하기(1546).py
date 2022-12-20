n = input()
numbers = list(map(int, input().split()))
m, sum = 0, 0

for i in numbers:
    sum += i
    if i > m:
        m = i
# max = max(numbers)
# sum = sum(numbers)
print(sum*100/m/int(n))