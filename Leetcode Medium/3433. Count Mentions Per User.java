// Leetcode Link : https://leetcode.com/problems/count-mentions-per-user/description/

// JAVA CODE : 

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events,(a,b)->{
            int first = Integer.parseInt(a.get(1));
            int second = Integer.parseInt(b.get(1));
            if(first == second){
                if(a.get(0).equals("OFFLINE"))return -1;
                if(b.get(0).equals("OFFLINE"))return 1;
                return 0;
            }else
            return first-second;
        });
        int[] res = new int[numberOfUsers];
        int[] online = new int[numberOfUsers];
        Arrays.fill(online,-60);

        for(int i = 0; i < events.size(); i++){
            List<String> s = events.get(i);
            String action = s.get(0);
            int time = Integer.parseInt(s.get(1));
            if(action.equals("OFFLINE")){
                int user = Integer.parseInt(s.get(2));
                online[user] = time;
            }else{
                if(s.get(2).equals("ALL")){
                    for(int j = 0; j < res.length; j++)res[j]++;
                }else if(s.get(2).equals("HERE")){
                    for(int j = 0; j < res.length; j++)if(online[j]+60 <= time)res[j]++;
                }else{
                    String[] users = s.get(2).split(" ");
                    for(String u: users){
                        int ind = Integer.parseInt(u.substring(2,u.length()));
                        res[ind]++;
                    }
                }
            }
        }
        return  res;
    }
}
