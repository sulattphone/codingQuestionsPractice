# From AlgoExpert

def sortedSquaredArray(array):
    # Write your code here.
    squared = [0 for _ in range(len(array))]
    start = 0
    end = len(array) - 1
    i = len(array) - 1

    while i > -1:
        #compare start and end
        start_num = array[start]
        end_num = array[end]
        if  abs(start_num) > abs(end_num):
            squared[i] = start_num * start_num
            start = start + 1
            
        elif abs(start_num) < abs(end_num):
            squared[i] = end_num * end_num
            end = end - 1

        else:
            squared[i] = start_num * start_num
            start = start + 1

        i = i - 1
    
    return squared;
