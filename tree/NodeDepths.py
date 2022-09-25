# From AlgoExpert

def nodeDepths(root):
    # Write your code here.
    return depth_adder(root, 0, 0)

def depth_adder(node, depth, depth_sum):
    if node is None:
        return depth_sum

    depth_sum = depth_sum + depth

    depth_sum = depth_adder(node.left, depth + 1, depth_sum)
    depth_sum = depth_adder(node.right, depth + 1, depth_sum)

    return depth_sum
    

    


# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
