class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
           for(int i = 0;i < prefix.length;i++){
             if(prefix[i] == k)count++;
             int remain = prefix[i]-k;
             if(map.containsKey(remain)){
                count +=map.get(remain);
             }
             map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
           }
        return count;
    }
}