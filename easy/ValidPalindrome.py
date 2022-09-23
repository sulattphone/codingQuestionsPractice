# LeetCode No.125
# From Algorithms and Data Structures Discord

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0 or len(s) == 1:
            return True
        
        left_pointer = 0
        right_pointer = len(s) - 1
        is_palindrome = True
        
        while (left_pointer <= right_pointer):
            left_char = s[left_pointer].lower()
            right_char = s[right_pointer].lower()
            
            if not left_char.isalnum():
                left_pointer += 1
            elif not right_char.isalnum():
                right_pointer -= 1
            else:
                if left_char == right_char:
                    left_pointer += 1
                    right_pointer -= 1
                else:
                    return False
        
        return is_palindrome
            
            