// LEETCODE LINK : 

// JAVA CODE : 

class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int a=1; a<=n; a++){
            int aa = a*a;
            for (int b=1; b<= n; b++){
                int bb = b*b;
                int sum = aa+bb;

                int c = (int)Math.sqrt(sum);
                if (c <= n && c*c == sum){
                    count++;
                }
            }
        }
        return count;
    }
}
