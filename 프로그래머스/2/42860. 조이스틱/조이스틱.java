class Solution {
    public int solution(String name) {
        int count = 0;
        for(int i = 0; i<name.length(); i++){
            char c = name.charAt(i);
            int n = c-'A';
            if(n > 13) n = 'Z'-c+1;
            n=Math.abs(n);
            count+=n;
        }
        int m = name.length()-1;
        for(int i = 0; i<name.length(); i++){
            int next = i+1;
            while(next < name.length() && name.charAt(next)=='A') next++;
            int candidate = Math.min(2*i+(name.length()-next), i+2*(name.length()-next));
            m = Math.min(m,candidate);
        }
        return count+m;
    }
}