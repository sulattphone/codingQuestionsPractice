#From AlgoExpert
def getNthFib(n):
    # Write your code here.
    cache = [0, 1]
    if n is 1 or n is 2:
        return cache[n-1]
    result = 0
    for i in range(3, n+1):
        cache_index = (i-1) % 2
        cache[cache_index] = cache[0] + cache[1]
        if i == n:
            result = cache[cache_index]
    return result

#Although this is more elegant (same though)
def solution3(n):
    lastTwo = [0, 1]
    if n is 1 or n is 2:
        return lastTwo[n-1]
    counter = 3
    while counter <= n:
        nextFib = lastTwo[0] + lastTwo[1]
        lastTwo[0] = lastTwo[1]
        lastTwo[1] = nextFib
        counter += 1
    return lastTwo[1]