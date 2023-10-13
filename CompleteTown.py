
'''
prompt: we are given n cities and coordinates for each city. We can reach any city from any other city. Find the average length of all possible
paths we can take to visit every city

High level sol:
    - all the possible paths we can take to go through all the cities is all the permutations of the city orders
    - total distance of path for each permutation
    - divide by the number of permutations to get the average


TC: (N!), SC: O(N)
'''

from itertools import permutations
from math import sqrt
def factorial(n):
    if n == 0: return 1
    else: return n * factorial(n-1)

n = int(input())

towns = []
for i in range(n):
    ln = input().split()
    x = int(ln[0])
    y = int(ln[1])
    towns.append((x,y))

totalDistance = 0
for perm in list(permutations(towns)):
    for i in range(n-1):
        x1 = perm[i][0]
        x2 = perm[i+1][0]

        y1 = perm[i][1]
        y2 = perm[i+1][1]

        totalDistance += sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
print(totalDistance / factorial(n))
