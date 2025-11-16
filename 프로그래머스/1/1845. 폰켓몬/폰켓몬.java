import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums) set.add(a);
        int n = nums.length/2;
        if(set.size()>=n) return n;
        else return set.size();
    }
}