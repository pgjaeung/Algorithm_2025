import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int [] score = new int[3];
        for(int i = 0; i<n; i++){
            if(answers[i] == p1[i%p1.length]) score[0]++;
            if(answers[i] == p2[i%p2.length]) score[1]++;
            if(answers[i] == p3[i%p3.length]) score[2]++;
        }
        List<Integer> list = new ArrayList<>(3);
        int max = 0;
        for(int i = 0; i<score.length; i++){
            if(max < score[i]) {
                max = score[i];
            }
            
        }
        for(int i = 0; i<score.length; i++){
            if(max == score[i]) list.add(i);
        }
        
        return list.stream().mapToInt(i -> i+1).toArray();
    }
}