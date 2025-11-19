import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int low=0, high=people.length-1;
        int boat=0;
        while(low<=high){
            if(people[low]+people[high]<=limit) {
                boat++;
                high--;
                low++;
            }
            else if(people[low]+people[high]>limit){
                high--;
                boat++;
            }
        }
        return boat;
    }
}