# From AlgoExpert

def nonConstructibleChange(coins):
    # Write your code here.
    sum = 0

    coins.sort()

    for value in coins:
        if value - sum >= 2:
            return sum + 1
        sum += value

    return sum + 1
