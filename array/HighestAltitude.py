# LeetCode No.1732
# From Algorithms and Data Structures Discord Group

class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        highest = 0
        sum_alt = 0
        
        for g in gain:
            sum_alt += g
            if sum_alt > highest:
                highest = sum_alt
        
        return highest