import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<number.length(); i++) {
            char c = number.charAt(i);
            
            while(sb.length()>0){
                if(k==0) break;
                if(sb.charAt(sb.length()-1)>=c) break;
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(c);
        }
        if(k>0) sb.setLength(sb.length()-k);
        return sb.toString();
    }
}