import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hash = new HashMap<>();
        for(String[] s : clothes) hash.put(s[1], hash.getOrDefault(s[1],0)+1);
        for(String s : hash.keySet()) answer *= hash.get(s)+1;
        answer--;
        return answer;
    }
}