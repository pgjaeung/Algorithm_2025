class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        return dfs(k,dungeons, visit);
        
    }
    public int dfs(int energy, int [][]dungeons, boolean[] visit){
        int max = 0;
        
        for(int i = 0; i<dungeons.length; i++){
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visit[i] && energy >=need){
                visit[i]=true;
                int clear = 1 + dfs(energy-cost, dungeons, visit);
                visit[i]=false;
                
                if(clear > max) max = clear;
            }
        }
        return max;
    }
}