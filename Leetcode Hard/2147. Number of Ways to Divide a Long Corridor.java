// LEETCODE LINK : https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/?envType=daily-question&envId=2025-12-14

// JAVA CODE : 

class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int seatCount = 0;
        long ways = 1;
        boolean sectionClosed = false;
        int cutOptions = 0;
        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                seatCount++;
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * cutOptions) % MOD;
                    cutOptions = 0;
                }
                if (seatCount % 2 == 0) {
                    sectionClosed = true;
                    cutOptions = 1;
                }
            } 
            else {
                if (sectionClosed) {
                    cutOptions++;
                }
            }
        }
        if (seatCount == 0 || seatCount % 2 != 0) return 0;
        return (int) ways;
    }
}
