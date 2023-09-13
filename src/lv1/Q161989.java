package lv1;

import java.util.Arrays;

public class Q161989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"AGZ", "BSSS"};
		String[] b = {"ASA","BGZ"};
		
		solution(a, b);
	}
	
	public static int[] solution(String[] keymap, String[] targets) {
		
		int[] answer = new int[targets.length];
		
		int index = 0;
		for(String target: targets) {
			int count = 0;
			
			for(int i = 0; i < target.length() ; i++){
				int minKeyCount = 99999999;
//				System.out.println(target.charAt(i) + "찾는 중");
				
				for(String key : keymap) {
					
					if(key.indexOf(target.charAt(i)) != -1) {
						
						if(minKeyCount > key.indexOf(target.charAt(i))) {
//							System.out.println("인덱스 찾음: "+key.indexOf(target.charAt(i)));
							 minKeyCount = key.indexOf(target.charAt(i));
						}
//						System.out.println("찾은인덱스"+key.indexOf(target.charAt(i)));
						
					}
				}
//				System.out.println("min "+ minKeyCount);
				count += minKeyCount + 1;
				
			}

			answer[index] = count >= 100000000 ? -1 : count;
			
			index++;
		}
		
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }

}
