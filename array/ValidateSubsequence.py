# From AlgoExpert

def isValidSubsequence(array, sequence):
    # Write your code here.

    first_pointer = 0
    second_pointer = 0

    if len(sequence) == 0:
        return True
    
    while second_pointer < len(sequence):
        if first_pointer >= len(array):
            return False

        if array[first_pointer] == sequence[second_pointer]:
            second_pointer += 1

        first_pointer += 1

    return True