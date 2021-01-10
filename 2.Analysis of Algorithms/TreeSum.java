package Chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        int n = nums.length;

        for(int k=0;k<n;k++){
            //大于0且必须相等
            if(k>0&&nums[k]==nums[k-1]){continue;}

            int l = k+1;
            int r = n-1;


            while(l<r){
                ArrayList<Integer> list = new ArrayList<>();


                if(nums[k]+nums[l]+nums[r]>0){
                    r--;
                }
                else if(nums[k]+nums[l]+nums[r]<0){
                    l++;
                }
                else if(nums[k]+nums[l]+nums[r]==0){
                    list.add(nums[k]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);

                    while(l<r&&nums[l]==nums[l+1]) l++;
                    while(l<r&&nums[r]==nums[r-1]) r--;

                    l++;
                    r--;
                }
            }

        }

        return res;

    }

}
