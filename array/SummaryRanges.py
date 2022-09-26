# LeetCode No. 228
# From Algorithms and Datastructures Discord

class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if len(nums) == 0:
            return []
        
        if len(nums) == 1:
            return [str(nums[0])]
        
        range_list = []
        one_range = str(nums[0])
        count = 1
        prev = nums[0]
        
        for i in range(1, len(nums)):
            current = nums[i]
            if current - prev > 1:
                if count > 1:
                    one_range += "->" + str(prev)
                range_list.append(one_range)
                one_range = str(current)
                count = 1
            else:
                count+=1
            prev = current
        
        if count > 1:
            one_range += "->" + str(prev)
        range_list.append(one_range)
        
        return range_list
                
                    
            
            