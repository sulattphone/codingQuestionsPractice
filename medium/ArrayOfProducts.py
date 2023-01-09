#From AlgoExpert
def arrayOfProducts(array):
    # Write your code here.
    n = len(array)
    left_prods = [1 for i in range(n)]
    right_prods = [1 for i in range(n)]
    result = [1 for i in range(n)]

    i = 1
    while i < n:
        left_prods[i] = left_prods[i-1] * array[i-1]
        i += 1

    i = n-2
    while i > -1:
        right_prods[i] = right_prods[i + 1] * array[i+1]
        i -= 1


    for i in range(n):
        result[i] = left_prods[i] * right_prods[i]

    return result
    
    
