package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Q178870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] solution(int[] sequence, int k) {
       int[] answer = { 0, sequence.length - 1 };

//			ArrayList<Integer[]> result = new ArrayList<>();

		int left = 0;
		int right = 0;

		int sum = sequence[0];
		int minLenght = sequence.length +1;
		while (true) {
//				System.out.println(left + " "+right + " "+sum +" " +minLenght);
			
			if(right == sequence.length) {
				sum -= sequence[left++];
				
				if(left > right || left == sequence.length && right == sequence.length) break;
				continue;
			}
			
			if(sum == k && minLenght > right - left) {
				minLenght = right - left;
				answer[0] = left;
				answer[1] = right;
				sum -= sequence[left++];
			}
			else if(sum < k) {
				if(right + 1 == sequence.length) break;
				sum += sequence[++right];
			}else if(sum > k) {
				sum -= sequence[left++];
			}else if(sum == k && minLenght == right - left){
				sum -= sequence[left++];
			}else {
				break;
			}
			
			
			
			if(left > right || left == sequence.length && right == sequence.length) break;
		}

		
//			System.out.println(Arrays.toString(answer));
		return answer;
    }
	

}
