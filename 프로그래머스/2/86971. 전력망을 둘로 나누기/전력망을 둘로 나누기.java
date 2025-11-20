import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int rev = 0; rev<wires.length; rev++){
            List<List<Integer>>graph = new ArrayList<>();
            for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
            for(int i = 0; i< wires.length; i++){
                if(i == rev) continue;
                int a = wires[i][0];
                int b = wires[i][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int count = bfsCount(1, graph, n);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    public int bfsCount(int start, List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer>q = new LinkedList<>();
        
        visited[start] = true;
        q.offer(start);
        
        int count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}