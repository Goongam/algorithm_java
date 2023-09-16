package lv2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q1844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	LinkedList<Integer[]> queue = new LinkedList<Integer[]>();

    int[][] maps = {{}};
    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    
    void bfs(){
        Integer[] start = {0,0};
        
        
        queue.add(start);
        // maps[0][0] = 0;
        
        while(queue.size() > 0){
            Integer[] current = queue.poll();
            Integer x = current[0];
            Integer y = current[1];
 
            
            
            // System.out.println(maps[0].length);
            
            for(int i = 0; i < 4 ;i++){

                int nextX = dir[i][0] + x;
                int nextY = dir[i][1] + y;

                
                
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;// 맵 밖
                if(nextX == 0 && nextY == 0) continue;
                
                if(maps[nextX][nextY] == 1) {
                    
                    maps[nextX][nextY] = maps[x][y] + 1;
                    
                    Integer[] next = {0,0};
                    next[0] = nextX;
                    next[1] = nextY;
                    queue.add(next);
                }
                
            }

        }    

    }
}
