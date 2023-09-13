package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q150370 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String today = "2022.05.19";
		String[] term = {"A 6", "B 12", "C 3"};
		String[] p = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		solution(today, term, p);
	}

	 public static int[] solution(String today, String[] terms, String[] privacies) {
	        
		 HashMap<String, Integer> termMap = new HashMap<>();
		 
		 ArrayList<Integer> result = new ArrayList<>();
		 
		 
		 for(String term : terms) {
			 termMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
		 }
		 
		 	int index = 1;
		 	for(String privacie : privacies) {
	        	String date = privacie.split(" ")[0];
	        	String t = privacie.split(" ")[1];
	        	
	        	//System.out.println(Arrays.toString(date.split("[.]")));
	        	int newyear = Integer.parseInt(date.split("[.]")[0]);
	        	int newmonth = Integer.parseInt(date.split("[.]")[1]);
	        	int newday = Integer.parseInt(date.split("[.]")[2]);
	        	
	        	int year = Integer.parseInt(today.split("[.]")[0]);
	        	int month = Integer.parseInt(today.split("[.]")[1]);
	        	int day = Integer.parseInt(today.split("[.]")[2]);
	        	
	        	int addYear = (int) Math.floor((newmonth + termMap.get(t)) / 12);
	        	int addMonth = (newmonth + termMap.get(t)) % 12;
//	        	System.out.println(addMonth);
	        	newyear += addYear;
	        	newmonth = addMonth;
	        	
//	        	System.out.println(month);
	        	
	        	newday -= 1;
	        	if(newday == 0) {
	        		newday = 28;
	        		newmonth -= 1;
	        	}
	        	
	        	if(newmonth == 0) {
	        		newmonth = 12;
	        		newyear -= 1;
	        	}
	        	
//	        	System.out.println(newyear + "/"+newmonth +"/"+newday);
	        	
	        	boolean isExpire = false;
	        	if( newyear < year) {
	        		isExpire = true;
	        	}else if(newyear == year && newmonth < month) {
	        		isExpire = true;
	        	}else if(newyear == year && newmonth == month && newday < day) {
	        		isExpire = true;
	        	}
	        	
	        	if(isExpire) result.add(index);
	        	//String expireDate = year+"."+month+"."+day;
	        	
	        	
	        	index++;
	        	
	        }
		 
		 	
		 	int[] answer = new int[result.size()];
		 	for(int i = 0; i< result.size(); i++) {
		 		answer[i] = result.get(i);
		 	}
		 	
		 	System.out.println(Arrays.toString(answer));
//		 	int[] answer = {};
	        return answer;
	    }
	 
}
