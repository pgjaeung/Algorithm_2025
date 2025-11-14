import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        int answer =0;
        for(int a : scoville)pq.offer(a);
        
        while(pq.size()>1 && pq.peek()<K){
            int first = pq.poll();
            int sec = pq.poll();
            int mix = first + (sec*2);
            pq.offer(mix);
            answer++;
        }
        if(!pq.isEmpty() && pq.peek() >= K) return answer;
        return -1;
    }
}