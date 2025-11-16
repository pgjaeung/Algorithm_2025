import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            if((100-progresses[i])%speeds[i]==0) q.add((100-progresses[i])/speeds[i]);
            else q.add((100-progresses[i])/speeds[i]+1);
        }
        // 7, 3, 9
        // 5, 10, 1, 1, 20, 1
        int now = q.poll();
        int count = 1;
        while(!q.isEmpty()){
            if(now>=q.peek()){
                count++;
                q.poll();
            }
            else{
                answer.add(count);
                count = 1;
                now = q.poll();
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
