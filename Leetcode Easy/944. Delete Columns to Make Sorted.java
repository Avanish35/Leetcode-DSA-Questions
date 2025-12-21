// LEETCODE LINK : https://leetcode.com/problems/delete-columns-to-make-sorted/

// JAVA CODE :

class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;
        
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
}
