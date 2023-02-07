#From AlgoExpert
def mergeOverlappingIntervals(intervals):
    # Write your code here.
    n = len(intervals)
    #sort intervals by first value
    intervals.sort()
    cumu_interval = intervals[0]
    result = []

    for i in range(1, n):
        current = intervals[i]
        if current[0] >= cumu_interval[0] and current[0] <= cumu_interval[1]:
            #merge
            cumu_interval[0] = min(cumu_interval[0], current[0])
            cumu_interval[1] = max(cumu_interval[1], current[1])
        else:
            result.append(cumu_interval)
            cumu_interval = current

    result.append(cumu_interval)
    return result
