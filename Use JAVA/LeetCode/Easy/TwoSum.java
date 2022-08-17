package LeetCode.Easy;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        outer: for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    answer[0] = i;
                    answer[1] = j;
                    break outer;
                }
            }
        }
         return answer;
     }
}
// https://leetcode.com/problems/two-sum/