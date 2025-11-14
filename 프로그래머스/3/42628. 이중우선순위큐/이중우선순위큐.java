import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(String s : operations){
            st = new StringTokenizer(s);
            char cmd = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            switch(cmd){
                case 'I':
                    tm.put(num, tm.getOrDefault(num,0)+1);
                    break;
                case 'D':
                    if(tm.isEmpty()) continue;
                    if(num>0){
                        int key = tm.lastKey();
                        if(tm.get(key)==1) tm.remove(key);
                        else tm.put(key, tm.get(key)-1);
                    }else{
                        int key = tm.firstKey();
                        if(tm.get(key)==1) tm.remove(key);
                        else tm.put(key, tm.get(key)-1);
                    }
                    
            }
        }
        if(tm.isEmpty()) return new int[]{0,0};
        else return new int[]{tm.lastKey(),tm.firstKey()};
    }
}