#From AlgoExpert
# My solution with O(n) time and O(n) space
def firstDuplicateValue(array):
    # Write your code here.
    n = len(array)
    map = {}

    for i in range(n):
        if map.get(array[i]) is None:
            map[array[i]] = i
        else:
            return array[i]

    return -1


# Solution from hints with O(n) time and O(1) space
# Since array has integers 1-n inclusive, map each num to index by subtracting 1 => 0-(n-1)
def firstDuplicateValue(array):
    # Write your code here.
    n = len(array)
    for i in range(n):
        cur = array[i]
        ind = abs(cur) - 1
        if array[ind] < 0:
            return abs(cur)
        array[ind] = array[ind] * -1

    return -1
        
