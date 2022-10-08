# From AlgoExpert
def tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest):
    # Write your code here.
    if fastest:
        redShirtSpeeds.sort()
        blueShirtSpeeds.sort(reverse=True)
    else:
        redShirtSpeeds.sort()
        blueShirtSpeeds.sort()

    totalSpeed = 0

    for i in range(len(redShirtSpeeds)):
        totalSpeed += max(redShirtSpeeds[i], blueShirtSpeeds[i])
    
    return totalSpeed
