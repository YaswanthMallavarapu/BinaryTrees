class Solution {
    public static void subsetP(int nums[],int target,int currsum,int idx,boolean can[]){
        if(can[0])return;
        if(idx==nums.length||currsum>target)return;
        if(currsum==target){
            can[0]=true;return;
        }
        else{
            subsetP(nums,target,currsum+nums[idx],idx+1,can);
            subsetP(nums,target,currsum,idx+1,can);
        }
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        int target=sum/2;
        if(sum%2!=0)return false;
        // boolean can[]=new boolean[1];
        // subsetP(nums,target,0,0,can);
        // return can[0];
        boolean dp[]=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int j=target;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[target];
    }
}