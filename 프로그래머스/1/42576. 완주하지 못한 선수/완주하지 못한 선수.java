import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hash = new HashMap<>();
        for(String s : participant) hash.put(s,hash.getOrDefault(s,0)+1);
        for(String s : completion) hash.put(s, hash.get(s)-1);
        for(String s : hash.keySet()) if(hash.get(s)>0) return s;
        return null;
    }
}