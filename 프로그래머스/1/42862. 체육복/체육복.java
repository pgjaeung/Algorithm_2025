class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] l = new boolean[n+2];
        boolean[] r = new boolean[n+2];
        
        for(int a : lost) l[a] = true;
        for(int a : reserve) r[a] = true;
        
        for(int i = 1; i<=n; i++){
            if(l[i] && r[i]) {
                l[i] = false;
                r[i] = false;
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(l[i]){
                if(r[i-1]){
                    l[i] = false;
                    r[i-1] = false;
                }
                else if(r[i+1]){
                    l[i] = false;
                    r[i+1] = false;
                 }
            }
        }
        
        int count = 0;
        for(int i = 1; i<=n; i++) if(l[i]) count++;
        return n-count;
    }
}