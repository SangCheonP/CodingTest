t1 = int(input())
have=list(map(int, input().split()))
have.sort()
t2 = int(input())
give=list(map(int, input().split()))

def find(target):
    left = 0
    right = t1 - 1
    while left <= right:
        mid = (left+right)//2
        if have[mid] == target:
            return True
        if have[mid] < target:
            left = mid +1
        elif have[mid] > target:
            right = mid -1

for i in range(t2):
    if find(give[i]):
        print(1, end=" ")
    else:
        print(0, end=" ")


# result = []

# for i in range(t2):
#     if find(give[i]):
#         result.append(1)
#     else:
#         result.append(1)

# for i in range(t2):
#     print(result[i])