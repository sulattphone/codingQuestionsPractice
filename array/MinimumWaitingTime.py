#From Algo Expert

def minimumWaitingTime(queries):
    # Write your code here.
    each_min_wait = sum = last_job = 0
    queries.sort();
    
    for q in queries:
        each_min_wait += last_job
        last_job = q
        sum += each_min_wait
    
    return sum
    

# Solution from community:
# Genius math 
# Sort in reverse and Execution time * index
# E.g. [9, 5, 3, 1] = 9*0 + 5*1 + 3*2 + 1*3 (no wait time for 9, 1 time waited for 5 by 9, etc.)

def minimumWaitingTime(queries):
    # Write your code here.
    queries.sort(reverse=True)
    min_wait = 0
    for index, q in enumerate(queries):
        min_wait += index * q

    return min_wait
