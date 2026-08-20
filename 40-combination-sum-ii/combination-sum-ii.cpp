void fun(int s,vector<int>&nums,vector<int>&tmp,vector<vector<int>>&ans,int target,map<vector<int>,int>&m1){
    if(s>target) return ;
    if(s==target){
        if(m1.find(tmp)==m1.end()){
        ans.push_back(tmp);
        m1[tmp]++;
        }
        return ;
    }

    for(int i=0;i<nums.size();i++){
        vector<int>ip=nums;

        if(i>0 && nums[i]==nums[i-1]) continue;

        //op.push_back(nums[i]);
        for(int j=0;j<=i;j++) ip.erase(ip.begin());

        tmp.push_back(nums[i]);

        fun(s+nums[i],ip,tmp,ans,target,m1);

        tmp.pop_back();
    }
}


class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& nums, int target) {
        vector<vector<int>>ans;
        sort(nums.begin(),nums.end());
        vector<int>tmp;
        map<vector<int>,int>m1;
        fun(0,nums,tmp,ans,target,m1);
        return ans;
    }
};
    