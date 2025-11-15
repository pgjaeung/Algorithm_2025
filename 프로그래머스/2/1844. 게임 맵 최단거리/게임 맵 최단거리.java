import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        // [1,0,1,1,1],
        // [1,0,1,0,1],
        // [1,0,1,1,1],
        // [1,1,1,0,1],
        // [0,0,0,0,1]
        int n = maps.length;
        int m = maps[0].length;
        
        int [][] dist = new int[n][m];
        boolean [][] visit = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visit[0][0] = true;
        dist[0][0] = 1;
        
        //좌우상하 순
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll(); //갱신
            int x = curr[0];
            int y = curr[1];
            
            if(x == n-1 && y == m -1) return dist[x][y];
            
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx >= n || ny >= m) continue;
                if(maps[nx][ny]==0) continue;
                if(visit[nx][ny]) continue;
                
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx,ny});
            }
        }
        return -1;
    }
}