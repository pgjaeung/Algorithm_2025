class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        String s = "AEIOU";
        
        int answer= 0;
        for(int i = 0; i<word.length(); i++){
            int idx = s.indexOf(word.charAt(i));
            answer += idx * weight[i] + 1;
        }
        return answer;
    }
}