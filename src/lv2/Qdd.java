package lv2;

import java.util.Arrays;
import java.util.LinkedList;

public class Qdd {

static int[][] arrayMaps = null;
    
    static boolean isLeverOn = false;

    static LinkedList<int[]> queue = new LinkedList();
    
    static int[][] dirs = {
        {-1, 0}, //상
        {1,0},
        {0,-1},
        {0,1}
    };
    
    static int[] startPos = {0,0};
    
    static void bfs(String[] maps){
        
        if(isLeverOn){
            //L이 시작지점
            for(int i = 0 ; i < maps.length ; i++){
                if(maps[i].indexOf('L') != -1){
                     
                    startPos[0] = i;
                    startPos[1] = maps[i].indexOf('L');
                }
            }
        }else{
            //S가 시작지점
            for(int i = 0 ; i < maps.length ; i++){
                if(maps[i].indexOf('S') != -1) {
                    startPos[0] = i;
                    startPos[1] = maps[i].indexOf('S');
                }
            }
            
        }
        
        //맵 초기화
        arrayMaps = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length ; i++){
            for(int j = 0; j < maps[0].length() ; j++){

                if(maps[i].charAt(j) == 'O') arrayMaps[i][j] = 0;
                else if(maps[i].charAt(j) == 'X') arrayMaps[i][j] = -1;
                else if(isLeverOn && maps[i].charAt(j) == 'S') arrayMaps[i][j] = -2;
                else if(!isLeverOn && maps[i].charAt(j) == 'L') arrayMaps[i][j] = -2;
                else arrayMaps[i][j] = 0;
            }
        }
        //0 지나갈수있음, -1 벽, -2 목표
        arrayMaps[startPos[0]][startPos[1]] = 1;
        // System.out.println(startPos[0] + "." +startPos[1]);
        queue.add(new int[]{startPos[0],startPos[1]});
        
        while(true){
        	
            int[] currentPos = queue.poll();
//            System.out.println(Arrays.toString(currentPos));
//            
            if(currentPos == null) {
//            	Arrays.deepToString(arrayMaps);
            	return;
            }
            
            // System.out.println(currentPos[0] +" "+currentPos[1]);
            for(int[] dir : dirs){

                    int nextXPos = currentPos[0] + dir[0];
                    int nextYPos = currentPos[1] + dir[1];

                    if(nextXPos < 0 || nextXPos >= maps.length || nextYPos < 0 || nextYPos >= arrayMaps[0].length || arrayMaps[nextXPos][nextYPos] == -1 || arrayMaps[nextXPos][nextYPos] >= 1) continue;

                    arrayMaps[nextXPos][nextYPos] = arrayMaps[currentPos[0]][currentPos[1]] + 1;

                    queue.add(new int[]{nextXPos, nextYPos});

            }
        }
        
    }
    
    public static int solution(String[] maps) {
    	
        bfs(maps);
//        System.out.println(Arrays.deepToString(arrayMaps));
//        int i = 0;
//        for(int i = 0; i < arrayMaps.length; i++) {
//        	for(int j = 0 ; j < arrayMaps[0].length; j++) {
//        		maps[i] += arrayMaps[i][j]+"";
//        	}
//        }
//        System.out.println(maps[0], d);
        int answer = 0;
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});
	}

}
