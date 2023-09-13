package lv1;

public class Q172928 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"SOO","OOO","OOO"};
		String[] b = {"E 2","S 2","W 1"};

		solution(a, b);
	}


    public static int[] solution(String[] park, String[] routes) {
    	
    	//시작지점 구하기
		int startPosX = 0;
		int startPosY = 0;
		for(int i = 0 ; i < park.length; i++) {
			if(park[i].indexOf('S') != -1) {
				startPosX = i;
				startPosY = park[i].indexOf('S');
			}
		}
		
		int currentPosX = startPosX;
		int currentPosY = startPosY;
		
		Loop1:
    	for(String route: routes) {
    		String[] r = route.split(" ");
    		String rotate = r[0];
    		int range = Integer.parseInt(r[1]);
    		
    		int[] direction = {0,0};
    		if(rotate.equals("N")) {direction[0] = -1; direction[1] = 0;}
    		else if(rotate.equals("S")) {direction[0] = 1; direction[1] = 0;}
    		else if(rotate.equals("W")) {direction[0] = 0; direction[1] = -1;}
    		else if(rotate.equals("E")) {direction[0] = 0; direction[1] = 1;}
    		
    		
    		int tmpPositionX = currentPosX;
    		int tmpPositionY = currentPosY;
    		for(int i = 0 ; i < range ; i++) {
    			tmpPositionX += direction[0];
    			tmpPositionY += direction[1];
    			
    			
    			if(tmpPositionX < 0 || tmpPositionX >= park.length ||
    					tmpPositionY < 0 || tmpPositionY >= park[0].length()
    					|| park[tmpPositionX].charAt(tmpPositionY) == 'X') {
    				continue Loop1;
    			}
    			
    		}
    		
    		currentPosX = tmpPositionX;
    		currentPosY = tmpPositionY;
    	}
		
		System.out.println(currentPosX + " "+currentPosY);
    	
        int[] answer = {};
        return answer;
    }
	
}
