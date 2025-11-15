                // first, find max number
                // sec, max number와 다른 행에서 find 2nd max number
                // third, swap 2nd max number
                // iterate sec stage
                // 여기서 sizes[i][0] >= sizes[i][1]이면 stop후 return max_w * max_h;
class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for(int i = 0; i<sizes.length; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            if(a<b){
                int temp = a;
                a = b;
                b = temp;
            }
            maxW = a > maxW ? a : maxW;
            maxH = b > maxH ? b : maxH;
        }
        return maxW * maxH;
       
    }
}