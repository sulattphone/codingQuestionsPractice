# From AlgoExpert
def classPhotos(redShirtHeights, blueShirtHeights):
    # Write your code here.
    can_be_taken = True
    redShirtHeights.sort()
    blueShirtHeights.sort()
    if redShirtHeights[0] < blueShirtHeights[0]:
        red_shorter = True
    elif redShirtHeights[0] > blueShirtHeights[0]:
        red_shorter = False
    else:
        return False

    for i in range(len(redShirtHeights)):
        if red_shorter and redShirtHeights[i] >= blueShirtHeights[i]:
            return False
        if not red_shorter and redShirtHeights[i] <= blueShirtHeights[i]:
            return False
    
    
    return can_be_taken
