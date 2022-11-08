t1 = int(input())
list_a = list(map(int, input().split()))
list_a.sort()
t2 = int(input())
list_b = list(map(int, input().split()))

def binary(target):
    left = 0
    right = t1 - 1
    while left <= right:
        mid = (left+right)//2
        if list_a[mid] == target:
            return True
        if list_a[mid] < target:
            left = mid+1
        elif list_a[mid] > target:
            right = mid-1

for i in range(t2):
    if binary(list_b[i]):
        print(1)
    else:
        print(0)