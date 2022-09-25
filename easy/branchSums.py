# From AlgoExpert

# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None



def branchSums(root):
    # Write your code here.
    sum_array = []
    branch_adder(root, 0, sum_array)
    return sum_array


def branch_adder(node, parent_sum, sum_array):
    if node is None:
        return
        
    current_sum = parent_sum + node.value
    if node.left is None and node.right is None:
        sum_array.append(current_sum)
        return
    
    branch_adder(node.left, current_sum, sum_array)
    branch_adder(node.right, current_sum, sum_array)
    
