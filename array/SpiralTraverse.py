#From AlgoExpert
def spiralTraverse(array):
    # Write your code here.
    n = len(array)
    m = len(array[0])
    result_array = [0 for x in range(n*m)]
    
    # create an array and populate with the sides
    direction_array = [m, n-1, m-1, n-2]
    array_counter = 0
    index = array_counter % 4
    direction_step_count = direction_array[index]
    result_index = 0
    i = 0
    j = -1
    
    # while loop that says till we encounter 0 in the map
    while (direction_step_count != 0):
        for count in range(direction_step_count):
            if index == 0: #RIGHT
                j = j if j >= m-1 else j + 1
                result_array[result_index] = array[i][j]
                result_index = result_index + 1
                
            if index == 1: #DOWN
                i = i if i >= n-1 else i + 1
                result_array[result_index] = array[i][j]
                result_index = result_index + 1
                
            if index == 2: #LEFT
                j = 0 if j <= 0 else j - 1
                result_array[result_index] = array[i][j]
                result_index = result_index + 1
                
            if index == 3: #UP
                i = 0 if i <= 0 else i - 1
                result_array[result_index] = array[i][j]
                result_index = result_index + 1
            
        direction_array[index] = direction_array[index] - 2
        array_counter += 1
        index = array_counter % 4
        direction_step_count = direction_array[index]

    return result_array

    
