# From AlgoExpert
def smallestDifference(arrayOne, arrayTwo):
    # Write your code here.
    arrayOne.sort()
    arrayTwo.sort()
    result = []
    smallestDiff = float('inf')
    pointer1 = pointer2 = 0

    while pointer1 < len(arrayOne) and pointer2 < len(arrayTwo):
        num1 = arrayOne[pointer1]
        num2 = arrayTwo[pointer2]
        diff = abs(num1-num2)

        if diff < smallestDiff:
            smallestDiff = diff
            result = [num1, num2]

        if num1 < num2:
            pointer1 += 1
        elif num1 > num2:
            pointer2 += 1
        else:
            return [num1, num2]

    return result
