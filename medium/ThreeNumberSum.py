# From AlgoExpert

def threeNumberSum(array, targetSum):
    # Write your code here.
    triplets_list = []
    
    for item_1 in array:
        sub_target = targetSum - item_1
        dict = {}
        for item_2 in array:
            potential_item_3 = sub_target - item_2
            if item_2 == item_1 or potential_item_3 == item_1:
                continue
            if dict.get(item_2) != None:
                triplet = [item_1, item_2, dict[item_2]]
                triplet.sort()
                if not triplet in triplets_list:
                    triplets_list.append(triplet)
            dict[potential_item_3] = item_2

    triplets_list.sort(key=lambda e: (e[0], e[1], e[2]))

    return triplets_list
