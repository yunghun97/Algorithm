package LeetCode.Easy;

import java.util.*;

public class SingleNumber {
    static int N;
    public int singleNumber(int[] nums) {
        N = nums.length;
        int answer = 0;
        int idx = 0;
        Arrays.sort(nums);
        while(true){
            boolean repeatCheck = false;
            if(check(idx-1)){
                if(nums[idx]==nums[idx-1]) repeatCheck = true;
            }
            if(check(idx+1)){
                if(nums[idx]==nums[idx+1]) repeatCheck = true;
            }
            if(!repeatCheck){
                answer = nums[idx];
                break;
            }
            idx++;
            
            if(idx==N) break;
        }
        return answer;
    }
    private boolean check(int num){
        if(num<0||num>=N) return false;
        return true;
    }    
}
// https://leetcode.com/problems/single-number/