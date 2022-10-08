# Leetcode No. 1480
# Leetcode Study Plan Level 1 Q1

class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        runningSum = [0 for i in range(len(nums))]
        eachSum = 0

        for i in range(len(nums)):
            eachSum += nums[i]
            runningSum[i] = eachSum

        return runningSum