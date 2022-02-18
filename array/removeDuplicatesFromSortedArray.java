class Solution {
    public int removeDuplicates(int[] nums) {
        int firstAvailableIndex = -1;
        int lastInt = nums[0];
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prev = nums[i-1];
            //sees first duplicate
            if (current == prev) {
                firstAvailableIndex = i;
                nums[i] = 101;
            } else if (current == lastInt){
                nums[i] = 101;
            //sees second duplicate
            } else {
            //sees a different number
                lastInt = current;
                k++;
                if (firstAvailableIndex > 0) {  
                    nums[firstAvailableIndex] = current;
                    nums[i] = 101;
                    firstAvailableIndex++;
                }
            }
            
        }
        return k;
        
    }
}
