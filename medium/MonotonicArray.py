#From AlgoExpert
def isMonotonic(array):
    # Write your code here.
    if len(array) <= 1:
        return True

    increasing=decreasing=False
    
    for i in range(1, len(array)):
        diff = array[i] - array[i-1]
        if increasing and diff < 0:
            return False
        if decreasing and diff > 0:
            return False

        # starting off the motion (either at first comparison or subsequent comparison after equals)
        if diff > 0:
            increasing = True
        elif diff < 0:
            decreasing = True

    return True
            
