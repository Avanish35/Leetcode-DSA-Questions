// Leetcode Link : https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

// Java Code :

class Solution {
    public int countOdds(int low, int high) {
        return ((high+1)/2)-(low/2);
    }
}
