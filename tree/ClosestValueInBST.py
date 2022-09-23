# From AlgoExpert

def findClosestValueInBst(tree, target):
    # Write your code here.
    closest = tree.value

    return recurse(tree, target, closest)
    
def recurse(sub_tree, target, closest):
    if sub_tree is None:
        return closest

    if target < sub_tree.value:
        closest_left = recurse(sub_tree.left, target, closest)
        closest = closest_left if is_closest(target, closest, closest_left) else closest

    if target > sub_tree.value:
        closest_right = recurse(sub_tree.right, target, closest)
        closest = closest_right if is_closest(target, closest, closest_right) else closest
    
    closest = sub_tree.value if is_closest(target, closest, sub_tree.value) else closest

    return closest

def is_closest(target, closest, potential):
    if abs(target - potential) < abs(target - closest):
        return True
    else:
        return False

# This is the class of the input tree. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
