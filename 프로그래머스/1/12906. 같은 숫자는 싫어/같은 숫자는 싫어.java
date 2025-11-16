import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer>answer = new ArrayList<>();
        int curr = arr[0];
        answer.add(curr);
        for(int i = 1; i<arr.length; i++){
            if(curr==arr[i]) continue;
            else{
                curr=arr[i];
                answer.add(curr);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}