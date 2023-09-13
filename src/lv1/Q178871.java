package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Q178871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"mumu", "soe", "poe", "kai", "mine"};
		String[] b = {"kai", "kai", "mine", "mine"};
		solution(a, b);
	}
	
	public static String[] solution(String[] players, String[] callings) {
        
		HashMap<String, Integer> nameToRank = new HashMap();
		HashMap<Integer,String> rankToName = new HashMap();
		
		for(int i = 0; i < players.length; i++) {
			nameToRank.put(players[i], i);
			rankToName.put(i, players[i]);
		}
		
		for(String calling : callings) {
			int myrank = nameToRank.get(calling);
			String frontPerson = rankToName.get(myrank-1);
			int frontPersonRank = nameToRank.get(frontPerson);
			
			
			nameToRank.replace(calling, myrank-1);
			rankToName.replace(myrank-1, calling);
			
			nameToRank.replace(frontPerson, frontPersonRank+1);
			rankToName.replace(frontPersonRank+1,frontPerson);
			
		}
		
		
		
		System.out.println(rankToName.values().toArray(new String[0]));
		

        return rankToName.values().toArray(new String[0]);
    }

}
