import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // request time pq
        PriorityQueue<int[]> reqPQ = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );
        for(int [] a : jobs) reqPQ.offer(a);
        // runtime pq
        PriorityQueue <int[]> runPQ = new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            }
        );
        // run list
        
        int t = 0;
        int ret_time = 0;
        while(!reqPQ.isEmpty() || !runPQ.isEmpty()){
            while(!reqPQ.isEmpty() && reqPQ.peek()[0] <= t){
                runPQ.offer(reqPQ.poll());
            }
            if(runPQ.isEmpty()){
                t = reqPQ.peek()[0];
                continue;
            }
            int[]curr = runPQ.poll();
            t += curr[1];
            ret_time += (t - curr[0]);
        }
        return ret_time/jobs.length;
    }
}