// Leetcode Link : https://leetcode.com/problems/find-subarrays-with-equal-sum/

// JAVA CODE : 

class Solution {
    public boolean findSubarrays(int[] array) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int  i = 0; i<array.length-1; i++){
            int sum = array[i] + array[i+1];
            if (map.containsKey(sum)){
                return true;
            }else{
                map.put(sum,true);
            }
        }
        return false;
    }
}
