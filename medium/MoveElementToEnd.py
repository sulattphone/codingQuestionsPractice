#From AlgoExpert
def moveElementToEnd(array, toMove):
    # Write your code here.
    leftPointer = 0
    rightPointer = len(array) - 1

    while leftPointer < rightPointer:
        leftNum = array[leftPointer]
        rightNum = array[rightPointer]

        if rightNum == toMove:
            rightPointer -= 1
        else:
            if leftNum == toMove:
                #swap
                array[leftPointer] = rightNum
                array[rightPointer] = leftNum
                leftPointer += 1 
                rightPointer -= 1
            else:
                leftPointer += 1   

    return array