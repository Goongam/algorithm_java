package lv1;

public class Q161990 {

	public static void main(String[] args) {
		String[] a = {"..", "#."};
		solution(a);
	}

	//"..........", 
	//".....#....", 
	//"......##..",
	// "...##.....", 
	//"....#....."
	public static int[] solution(String[] wallpaper) {
        
		int minY = wallpaper.length;
		int maxY = 0;
		int minX = wallpaper[0].length();
		int maxX = 0;
		boolean firstY = true;
		boolean firstX = true;
		
		for(int i = 0; i < wallpaper.length; i++) {
			int index = wallpaper[i].indexOf('#');
			int lindex = wallpaper[i].lastIndexOf("#");
			
			if( index != -1 && i < minY ) { //최초 나오는 #
				minY = i;
			}
			
			if(index != -1 && index < minX) minX = index;
			if(lindex != -1 && lindex > maxX) {
				System.out.println(lindex);
				maxX = lindex;
			}
			
			if(index != -1 && i > maxY) {
//				System.out.println(index);
				maxY = i; //마지막으로 나오는 #
			}
		}
		
		System.out.println(minY);
		System.out.println(minX);
		System.out.println(maxY + 1);
		System.out.println(maxX + 1);
		
		int[] answer = {minY, minX, maxY+1, maxX+1};
        return answer;
    }
}
