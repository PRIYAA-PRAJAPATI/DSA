class Solution {
    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i+=2){
            int a = nums[i];
            int b = nums[i+1];
            int digits = 0;
            int temp = b;
            while(temp>0){
                digits++;
                temp/=10;
            }
            int merged = a*(int)Math.pow(10,digits)+b;
            min = Math.min(min,merged);
        }
        return min;
    }
}