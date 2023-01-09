#From AlgoExpert
def longestPeak(array):
    # Write your code here.
    count = 1
    maxCount = 0
    s_increase = False
    s_decrease = False
    last_slope = 0

    for i in range(len(array)-1):
        if array[i+1] > array[i]:
            s_increase = True
            s_decrease = False
            if last_slope == -1:
                count = 2
            else:
                count += 1
            last_slope = 1
        elif array[i+1] < array[i]:
            s_decrease = True
            last_slope = -1
            if s_increase is True:
                count += 1
                maxCount = max(count, maxCount)
        else:
            s_increase = False
            s_decrease = False
            last_slope = 0
            count = 1

    
    return maxCount
