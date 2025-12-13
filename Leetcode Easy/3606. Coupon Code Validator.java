// LEETCODE LINK : https://leetcode.com/problems/coupon-code-validator/?envType=daily-question&envId=2025-12-13

// JAVA CODE : 

class Solution {
    private boolean validCoupon(String s) {
        if (s == null || s.length() == 0) return false;
        return s.matches("[A-Za-z0-9_]+");
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("electronics", new ArrayList<>());
        map.put("grocery", new ArrayList<>());
        map.put("pharmacy", new ArrayList<>());
        map.put("restaurant", new ArrayList<>());
        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (validCoupon(code[i]) && map.containsKey(businessLine[i])) {
                map.get(businessLine[i]).add(code[i]);
            }
        }
        List<String> result = new ArrayList<>();
        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};
        for (String key : order) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.addAll(list);
        }
        return result;
    }
}
