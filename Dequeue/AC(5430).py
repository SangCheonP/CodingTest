from sys import stdin
from collections import deque
import re

for _ in range(int(stdin.readline())):
    command = list(stdin.readline().rstrip())
    N = int(stdin.readline())
    #numbers = re.findall(r'\d', stdin.readline().rstrip()) # 숫자 추출 및 낱개로 분리하여 List로 리턴
    numbers = stdin.readline().rstrip()[1:-1].split(',')
    deq = deque(numbers)
    flag = 0
    for i in command:
        if i == 'R':
            flag += 1
        elif i == 'D':
            if N <= 0:
                print('error')
                break
            else:
                if flag % 2 == 0:
                    deq.popleft()
                    N -= 1
                else:
                    deq.pop()
                    N -= 1
    else:
        if flag % 2 == 0:
            print('[' + ','.join(deq) + ']')
        else:
            deq.reverse()
            print('[' + ','.join(deq) + ']')