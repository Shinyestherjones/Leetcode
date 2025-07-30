class Solution {
    public int longestSubarray(int[] nums) {
       
        int max = 0;

         for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

          int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == max) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}

        
    
