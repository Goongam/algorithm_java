package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Q176963 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"may", "kein", "kain", "radi"};
		int[] b = {5, 10, 1, 3};
		String[][] c = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}};
		solution(a, b, c);
	}
	
	
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		
		HashMap<String, Integer> score = new HashMap();
		
		for(int i = 0 ; i < name.length; i++) {
			score.put(name[i], yearning[i]);
		}
		
		int[] result = new int[photo.length];
		
		
		for(int i = 0; i < photo.length ; i++) {
			int sc = 0;
			for(int k = 0 ; k < photo[i].length ; k++) {
				if(score.get(photo[i][k]) != null) sc += score.get(photo[i][k]);
			}
			result[i] = sc;
		}
		
//		System.out.println();
		
//        int[] answer = {};
        return result;
    }

}
