# LeetCode No.14

class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        prefix = strs[0]
        
        for i in range(len(strs)):
            current = strs[i]
            prefix = self.compare_prefix(prefix, current)
            if prefix == "":
                return prefix
        
        return prefix
    
    def compare_prefix(self, prefix, current):
        if prefix == "" or current == "":
            return ""
        
        if prefix[0] != current[0]:
            return ""
        
        new_prefix = ""
        i = 0
        while i < min(len(prefix), len(current)) and prefix[i] == current[i]:
            new_prefix += prefix[i]
            i += 1
        
        return new_prefix