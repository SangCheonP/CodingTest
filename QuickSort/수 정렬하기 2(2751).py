# def quick_sort(arr):
#     if len(arr)<=1:
#         return arr
#     pivot = arr[len(arr)//2]
#     less_arr, equal_arr, lage_arr = [], [], []
#     for num in arr:
#         if num < pivot:
#             less_arr.append(num)
#         elif num > pivot:
#             lage_arr.append(num)
#         else:
#             equal_arr.append(num)
#     return quick_sort(less_arr) + equal_arr + quick_sort(lage_arr)

list = []
for i in range(int(input())):
    list.append(int(input()))
# list1 = quick_sort(list)
list.sort()
for i in range(len(list)):
    print(list[i])