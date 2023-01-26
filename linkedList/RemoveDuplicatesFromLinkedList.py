#From AlgoExpert
# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def removeDuplicatesFromLinkedList(linkedList):
    # Write your code here.
    last_value = None
    prev_node = None
    current_node = linkedList

    while current_node is not None:
        if prev_node is None:
            prev_node = current_node
            current_node = current_node.next
        else:
            if current_node.value == prev_node.value:
                prev_node.next = current_node.next
                current_node = current_node.next
            else:
                prev_node = current_node
                current_node = current_node.next
    
    return linkedList
