// LEETCODE LINK : https://leetcode.com/problems/hamming-distance/description/

// JAVA CODE :

class Solution {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z!=0){
            z&=(z-1);
            count++;
        }
        return count;
    }
}
