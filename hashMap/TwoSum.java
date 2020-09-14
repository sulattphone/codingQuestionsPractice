class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer,Integer>();
        int[] indices = new int[2];
        
        for (int i = 0; i<nums.length; i++)
        {
            if(!hMap.containsKey(nums[i]))
            {
                hMap.put(target - nums[i], i);
            }
            else
            {
                indices[0] = hMap.get(nums[i]);
                indices[1] = i;
               
            }
        }
        return indices;
    }
}
