import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> count = new HashMap<>(); // music count
    	HashMap<String, HashMap<Integer,Integer>> music = new HashMap<>(); // index별
    	ArrayList<Integer> answer = new ArrayList<>();
    	for(int i = 0; i<genres.length; i++) {
    		if(!count.containsKey(genres[i])) { // new genres
    			music.put(genres[i], new HashMap<Integer,Integer>());
    			music.get(genres[i]).put(i, plays[i]);
    			count.put(genres[i], plays[i]);
    		}
    		else { // exist genres
    			music.get(genres[i]).put(i, plays[i]);
    			count.put(genres[i], count.get(genres[i])+plays[i]);
    		}
    	}
    	List<String> list = new ArrayList<>(count.keySet());
    	Collections.sort(list,(s1,s2) -> count.get(s2)-count.get(s1));
    	
    	for(String s : list) {
    		HashMap<Integer,Integer> tempHash = music.get(s);
    		List<Integer> tempList = new ArrayList(tempHash.keySet());
    		Collections.sort(tempList,(s1,s2)->tempHash.get(s2) - tempHash.get(s1));
    		answer.add(tempList.get(0));
    		if(tempList.size()>1) answer.add(tempList.get(1));
    	}
    	
    	int []res = new int[answer.size()];
    	for(int i = 0; i<res.length; i++) res[i] = answer.get(i);
    	
    	return res;
    }
}